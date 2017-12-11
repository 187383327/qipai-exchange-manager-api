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

@Comment(value = "商品类别 - 更新商品类别")
@MicroApiAnnotation(type = "read", version = "v1.0.35")
public class GoodsCategory_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getCategoryId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getName())) {
                fields.add(new FieldToUpdate("name", req.getName()));
            }
            if (StringUtils.isNoneBlank(req.getPicture())) {
                fields.add(new FieldToUpdate("picture", req.getPicture()));
            }
            if (req.getReorder() != null) {
                fields.add(new FieldToUpdate("reorder", req.getReorder()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(GoodsCategory.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getCategoryId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "商品类别ID")
        @Required(value = true)
        private String categoryId;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        @Comment(value = "商品类别名称")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "商品类别图片URL")
        @Required(value = true)
        private String picture;

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        @Comment(value = "排序")
        @Required(value = true)
        private Integer reorder;

        public Integer getReorder() {
            return reorder;
        }

        public void setReorder(Integer reorder) {
            this.reorder = reorder;
        }
    }
}
