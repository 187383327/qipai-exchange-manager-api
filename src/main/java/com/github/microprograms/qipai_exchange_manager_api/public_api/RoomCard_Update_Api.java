package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "房卡 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.65")
public class RoomCard_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getToken())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        Department department = Commons.queryDepartmentById(departmentMember.getDepartmentId());
        if (!Commons.hasPermission(department, PermissionEnum.roomCardUpdate)) {
            throw new MicroApiExecuteException(ErrorCodeEnum.permission_denied);
        }
        if (StringUtils.isBlank(req.getRoomCardId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getName())) {
                fields.add(new FieldToUpdate("name", req.getName()));
            }
            if (StringUtils.isNoneBlank(req.getCoverImgUrl())) {
                fields.add(new FieldToUpdate("coverImgUrl", req.getCoverImgUrl()));
            }
            if (req.getPrice() != null) {
                fields.add(new FieldToUpdate("price", req.getPrice()));
            }
            if (req.getGoldCoin() != null) {
                fields.add(new FieldToUpdate("goldCoin", req.getGoldCoin()));
            }
            if (fields.isEmpty()) {
                throw new MicroApiExecuteException(ErrorCodeEnum.no_fields_need_to_be_updated);
            }
            conn.createStatement().executeUpdate(new UpdateSql(RoomCard.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getRoomCardId()).toString();
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

        @Comment(value = "房卡ID")
        @Required(value = true)
        private String roomCardId;

        public String getRoomCardId() {
            return roomCardId;
        }

        public void setRoomCardId(String roomCardId) {
            this.roomCardId = roomCardId;
        }

        @Comment(value = "房卡标题")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "房卡封面图")
        @Required(value = true)
        private String coverImgUrl;

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
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
