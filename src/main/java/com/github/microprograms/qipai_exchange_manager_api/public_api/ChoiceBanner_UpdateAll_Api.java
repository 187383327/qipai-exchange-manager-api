package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "会员专区Banner - 更新全部")
@MicroApiAnnotation(type = "read", version = "v1.0.28")
public class ChoiceBanner_UpdateAll_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "Banner列表(全部)")
        @Required(value = true)
        private java.util.List<Banner> banners;

        public java.util.List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(java.util.List<Banner> banners) {
            this.banners = banners;
        }
    }
}
