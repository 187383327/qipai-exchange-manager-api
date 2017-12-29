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

@Comment(value = "商品/优选商品 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.63")
public class Goods_Update_Api {

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
        if (!Commons.hasPermission(department, PermissionEnum.goodsUpdate)) {
            throw new MicroApiExecuteException(ErrorCodeEnum.permission_denied);
        }
        if (StringUtils.isBlank(req.getGoodsId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getCategoryId())) {
                fields.add(new FieldToUpdate("categoryId", req.getCategoryId()));
            }
            if (StringUtils.isNoneBlank(req.getName())) {
                fields.add(new FieldToUpdate("name", req.getName()));
            }
            if (req.getPrice() != null) {
                fields.add(new FieldToUpdate("price", req.getPrice()));
            }
            if (req.getVipPrice() != null) {
                fields.add(new FieldToUpdate("vipPrice", req.getVipPrice()));
            }
            if (req.getGoldVipPrice() != null) {
                fields.add(new FieldToUpdate("goldVipPrice", req.getGoldVipPrice()));
            }
            if (req.getReorder() != null) {
                fields.add(new FieldToUpdate("reorder", req.getReorder()));
            }
            if (StringUtils.isNoneBlank(req.getPictures())) {
                fields.add(new FieldToUpdate("pictures", req.getPictures()));
            }
            if (fields.isEmpty()) {
                throw new MicroApiExecuteException(ErrorCodeEnum.no_fields_need_to_be_updated);
            }
            conn.createStatement().executeUpdate(new UpdateSql(Goods.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getGoodsId()).toString();
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

        @Comment(value = "商品ID")
        @Required(value = true)
        private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        @Comment(value = "商品类别编号")
        @Required(value = true)
        private String categoryId;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        @Comment(value = "商品名")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "商品价格(元宝)")
        @Required(value = true)
        private Integer price;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Comment(value = "会员价格(元宝)")
        @Required(value = true)
        private Integer vipPrice;

        public Integer getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(Integer vipPrice) {
            this.vipPrice = vipPrice;
        }

        @Comment(value = "钻石会员(元宝)")
        @Required(value = true)
        private Integer goldVipPrice;

        public Integer getGoldVipPrice() {
            return goldVipPrice;
        }

        public void setGoldVipPrice(Integer goldVipPrice) {
            this.goldVipPrice = goldVipPrice;
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

        @Comment(value = "商品主图(JsonArray)")
        @Required(value = true)
        private String pictures;

        public String getPictures() {
            return pictures;
        }

        public void setPictures(String pictures) {
            this.pictures = pictures;
        }
    }
}
