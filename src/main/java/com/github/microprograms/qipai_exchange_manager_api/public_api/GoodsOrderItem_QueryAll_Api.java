package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "商品订单项 - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.31")
public class GoodsOrderItem_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

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
