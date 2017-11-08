package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.UUID;

import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.IgniteUtils;
import com.github.microprograms.qipai_exchange_manager_api.utils.InsertSql;

@Comment(value = "商品类别 - 新增商品类别")
@MicroApiAnnotation(type = "read", version = "v1.0.6")
public class GoodsCategory_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection()) {
            GoodsCategory goodsCategory = new GoodsCategory();
            goodsCategory.setId(UUID.randomUUID().toString());
            goodsCategory.setName(req.getName());
            goodsCategory.setReorder(req.getReorder());
            goodsCategory.setDtCreate(System.currentTimeMillis());
            conn.createStatement().executeUpdate(InsertSql.build(goodsCategory));
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "商品类别名称") @Required(value = true) private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "排序") @Required(value = true) private Integer reorder;

        public Integer getReorder() {
            return reorder;
        }

        public void setReorder(Integer reorder) {
            this.reorder = reorder;
        }
    }
}
