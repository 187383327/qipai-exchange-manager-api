package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "图文 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.28")
public class ImageText_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "图文ID")
        @Required(value = true)
        private String imageTextId;

        public String getImageTextId() {
            return imageTextId;
        }

        public void setImageTextId(String imageTextId) {
            this.imageTextId = imageTextId;
        }
    }
}
