package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "商品 - 添加新商品")
@MicroApiAnnotation(type = "read", version = "v1.0.5")
public class Goods_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "商品类别编号")
        @Required(value = true)
        private Integer categoryId;

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
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
