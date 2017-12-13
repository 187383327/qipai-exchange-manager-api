package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.UUID;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_core.model.NewStock;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "库存 - 新增入库")
@MicroApiAnnotation(type = "read", version = "v1.0.38")
public class Stock_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            NewStock obj = new NewStock();
            obj.setId(UUID.randomUUID().toString());
            obj.setGoodsId(req.getGoodsId());
            obj.setNewStock(req.getAmount());
            conn.createStatement().executeUpdate(InsertSql.build(obj));
        }
        Response resp = new Response();
        return resp;
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
