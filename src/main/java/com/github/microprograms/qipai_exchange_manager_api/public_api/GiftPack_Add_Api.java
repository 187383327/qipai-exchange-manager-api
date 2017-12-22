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
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "礼包 - 添加")
@MicroApiAnnotation(type = "read", version = "v1.0.55")
public class GiftPack_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            GiftPack obj = new GiftPack();
            obj.setId(UUID.randomUUID().toString());
            obj.setCoverImgUrl(req.getCoverImgUrl());
            obj.setName(req.getName());
            obj.setContent(req.getContent());
            obj.setPrice(req.getPrice());
            obj.setDtCreate(System.currentTimeMillis());
            obj.setIsDelete(0);
            conn.createStatement().executeUpdate(InsertSql.build(obj));
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "礼包封面图")
        @Required(value = true)
        private String coverImgUrl;

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        @Comment(value = "礼包名称")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "礼包内容(JsonArray)")
        @Required(value = true)
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Comment(value = "会员专享礼包价")
        @Required(value = true)
        private Integer price;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }
}
