package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "房卡 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.18")
public class RoomCard_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "房卡ID")
        @Required(value = true)
        private String roomCardId;

        public String getRoomCardId() {
            return roomCardId;
        }

        public void setRoomCardId(String roomCardId) {
            this.roomCardId = roomCardId;
        }
    }
}
