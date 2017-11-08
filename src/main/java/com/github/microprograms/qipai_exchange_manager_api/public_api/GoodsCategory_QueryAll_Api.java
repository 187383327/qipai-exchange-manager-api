package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "商品类别 - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.6")
public class GoodsCategory_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "商品类别列表(全部)")
        @Required(value = true)
        private java.util.List<GoodsCategory> data;

        public java.util.List<GoodsCategory> getData() {
            return data;
        }

        public void setData(java.util.List<GoodsCategory> data) {
            this.data = data;
        }
    }
}
