package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.enums.MicroApiReserveResponseCodeEnum;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_core.model.NewStock;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "库存 - 新增入库")
@MicroApiAnnotation(type = "read", version = "v1.0.54")
public class Stock_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        if (StringUtils.isBlank(req.getGoodsId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        Goods goods = Commons.queryGoodsById(req.getGoodsId());
        if (goods == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.not_exists);
        }
        Connection conn = IgniteUtils.getConnection(Consts.jdbc_url);
        try {
            conn.setAutoCommit(false);
            int amount = req.getAmount();
            boolean updateStockSuccess = updateStock(conn, goods, amount);
            if (!updateStockSuccess) {
                throw new MicroApiExecuteException(ErrorCodeEnum.concurrency_modification_exception);
            }
            boolean insertNewStockRecordSuccess = insertNewStockRecord(conn, goods, amount);
            if (!insertNewStockRecordSuccess) {
                throw new MicroApiExecuteException(ErrorCodeEnum.concurrency_modification_exception);
            }
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            resp.error(MicroApiReserveResponseCodeEnum.api_execute_exception, e);
        } finally {
            conn.close();
        }
        return resp;
    }

    private static boolean updateStock(Connection conn, Goods goods, int amount) throws SQLException {
        List<FieldToUpdate> fields = new ArrayList<>();
        fields.add(new FieldToUpdate("stock", goods.getStock() + amount));
        fields.add(new FieldToUpdate("dtLastModify", System.currentTimeMillis()));
        String finalCondition = Where.and(Condition.build("id=", goods.getId()), Condition.build("stock=", goods.getStock()), Condition.build("dtLastModify=", goods.getDtLastModify())).toString();
        int count = conn.createStatement().executeUpdate(new UpdateSql(Goods.class).fields(fields).where(finalCondition).build());
        return count != 0;
    }

    private static boolean insertNewStockRecord(Connection conn, Goods goods, int amount) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        NewStock obj = new NewStock();
        obj.setId(UUID.randomUUID().toString());
        obj.setGoodsId(goods.getId());
        obj.setGoodsName(goods.getName());
        obj.setAmount(amount);
        obj.setOldStock(goods.getStock());
        obj.setNewStock(goods.getStock() + amount);
        obj.setDtCreate(System.currentTimeMillis());
        int count = conn.createStatement().executeUpdate(InsertSql.build(obj));
        return count != 0;
    }

    public static class Req extends Request {

        @Comment(value = "商品编号")
        @Required(value = true)
        private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        @Comment(value = "新增入库数量")
        @Required(value = false)
        private Integer amount;

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }
}
