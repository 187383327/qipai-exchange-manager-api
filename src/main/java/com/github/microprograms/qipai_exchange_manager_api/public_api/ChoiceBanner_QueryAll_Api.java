package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "会员专区Banner - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.28")
public class ChoiceBanner_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "Banner列表(全部)")
        @Required(value = true)
        private java.util.List<Banner> data;

        public java.util.List<Banner> getData() {
            return data;
        }

        public void setData(java.util.List<Banner> data) {
            this.data = data;
        }
    }
}
