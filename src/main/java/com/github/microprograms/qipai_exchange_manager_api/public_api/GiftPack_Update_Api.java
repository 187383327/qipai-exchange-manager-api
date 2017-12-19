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
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "礼包 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.43")
public class GiftPack_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getGiftPackId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getCoverImgUrl())) {
                fields.add(new FieldToUpdate("coverImgUrl", req.getCoverImgUrl()));
            }
            if (StringUtils.isNoneBlank(req.getName())) {
                fields.add(new FieldToUpdate("name", req.getName()));
            }
            if (StringUtils.isNoneBlank(req.getContent())) {
                fields.add(new FieldToUpdate("content", req.getContent()));
            }
            if (req.getPrice() != null) {
                fields.add(new FieldToUpdate("price", req.getPrice()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(GiftPack.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getGiftPackId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "礼包ID")
        @Required(value = true)
        private String giftPackId;

        public String getGiftPackId() {
            return giftPackId;
        }

        public void setGiftPackId(String giftPackId) {
            this.giftPackId = giftPackId;
        }

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
