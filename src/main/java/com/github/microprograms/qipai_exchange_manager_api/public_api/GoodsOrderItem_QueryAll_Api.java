package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品订单项 - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.61")
public class GoodsOrderItem_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        if (StringUtils.isBlank(req.getGoodsOrderId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(GoodsOrderItem.class).where(finalCondition).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, GoodsOrderItem.class));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("orderId=", req.getGoodsOrderId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "Token")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "商品订单ID")
        @Required(value = true)
        private String goodsOrderId;

        public String getGoodsOrderId() {
            return goodsOrderId;
        }

        public void setGoodsOrderId(String goodsOrderId) {
            this.goodsOrderId = goodsOrderId;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "商品订单项列表(全部)")
        @Required(value = true)
        private java.util.List<GoodsOrderItem> data;

        public java.util.List<GoodsOrderItem> getData() {
            return data;
        }

        public void setData(java.util.List<GoodsOrderItem> data) {
            this.data = data;
        }
    }
}
