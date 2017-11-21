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

@Comment(value = "商品 - 添加新商品")
@MicroApiAnnotation(type = "read", version = "v1.0.22")
public class Goods_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            Goods goods = new Goods();
            goods.setId(UUID.randomUUID().toString());
            goods.setCategoryId(req.getCategoryId());
            goods.setName(req.getName());
            goods.setPrice(req.getPrice());
            goods.setVipPrice(req.getVipPrice());
            goods.setGoldVipPrice(req.getGoldVipPrice());
            goods.setReorder(req.getReorder());
            goods.setStock(req.getStock());
            goods.setPictures(req.getPictures());
            goods.setDetail(req.getDetail());
            goods.setDtCreate(System.currentTimeMillis());
            goods.setIsDelete(0);
            conn.createStatement().executeUpdate(InsertSql.build(goods));
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

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

        @Comment(value = "库存")
        @Required(value = true)
        private Integer stock;

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
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

        @Comment(value = "详情(富文本)")
        @Required(value = true)
        private String detail;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
