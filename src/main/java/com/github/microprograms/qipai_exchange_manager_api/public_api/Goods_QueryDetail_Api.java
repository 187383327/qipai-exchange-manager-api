package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "商品 - 查询详情")
@MicroApiAnnotation(type = "read", version = "v1.0.19")
public class Goods_QueryDetail_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "商品ID")
        @Required(value = true)
        private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "商品详情")
        @Required(value = true)
        private Goods data;

        public Goods getData() {
            return data;
        }

        public void setData(Goods data) {
            this.data = data;
        }
    }
}
