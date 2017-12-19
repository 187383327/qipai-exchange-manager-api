package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.ignite_utils.sql.dml.SelectCountSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品类别 - 新增商品类别")
@MicroApiAnnotation(type = "read", version = "v1.0.41")
public class GoodsCategory_Add_Api {

    public static final int goods_category_limit = 5;

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (isFull()) {
            throw new MicroApiExecuteException(ErrorCodeEnum.goods_category_over_limit);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            GoodsCategory goodsCategory = new GoodsCategory();
            goodsCategory.setId(UUID.randomUUID().toString());
            goodsCategory.setName(req.getName());
            goodsCategory.setPicture(req.getPicture());
            goodsCategory.setReorder(req.getReorder());
            goodsCategory.setDtCreate(System.currentTimeMillis());
            conn.createStatement().executeUpdate(InsertSql.build(goodsCategory));
        }
        Response resp = new Response();
        return resp;
    }

    private static int queryGoodsCategoryCount() throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(GoodsCategory.class).build());
            return IgniteUtils.getCount(selectCountRs);
        }
    }

    private static boolean isFull() throws SQLException {
        return queryGoodsCategoryCount() >= goods_category_limit;
    }

    public static class Req extends Request {

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
