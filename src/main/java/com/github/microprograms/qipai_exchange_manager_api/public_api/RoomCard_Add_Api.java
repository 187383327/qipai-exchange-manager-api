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
import com.github.microprograms.qipai_exchange_core.model.RoomCard;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "房卡 - 添加新房卡")
@MicroApiAnnotation(type = "read", version = "v1.0.20")
public class RoomCard_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            RoomCard obj = new RoomCard();
            obj.setId(UUID.randomUUID().toString());
            obj.setEnable(1);
            obj.setGoldCoin(req.getGoldCoin());
            obj.setName(req.getName());
            obj.setPrice(req.getPrice());
            obj.setSalesVolume(0);
            conn.createStatement().executeUpdate(InsertSql.build(obj));
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "房卡标题")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "价格(元)")
        @Required(value = true)
        private Integer price;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Comment(value = "金币")
        @Required(value = true)
        private Integer goldCoin;

        public Integer getGoldCoin() {
            return goldCoin;
        }

        public void setGoldCoin(Integer goldCoin) {
            this.goldCoin = goldCoin;
        }
    }
}
