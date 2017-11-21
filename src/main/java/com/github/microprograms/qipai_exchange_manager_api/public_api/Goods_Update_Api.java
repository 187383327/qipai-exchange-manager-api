package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.Pair;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.20")
public class Goods_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getGoodsId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<Pair> pairs = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getCategoryId())) {
                pairs.add(new Pair("categoryId=", req.getCategoryId()));
            }
            if (StringUtils.isNoneBlank(req.getName())) {
                pairs.add(new Pair("name=", req.getName()));
            }
            if (req.getPrice() != null) {
                pairs.add(new Pair("price=", req.getPrice()));
            }
            if (req.getVipPrice() != null) {
                pairs.add(new Pair("vipPrice=", req.getVipPrice()));
            }
            if (req.getGoldVipPrice() != null) {
                pairs.add(new Pair("goldVipPrice=", req.getGoldVipPrice()));
            }
            if (req.getReorder() != null) {
                pairs.add(new Pair("reorder=", req.getReorder()));
            }
            if (StringUtils.isNoneBlank(req.getPictures())) {
                pairs.add(new Pair("pictures=", req.getPictures()));
            }
            if (StringUtils.isNoneBlank(req.getDetail())) {
                pairs.add(new Pair("detail=", req.getDetail()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(Goods.class).pairs(pairs).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getGoodsId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "商品ID") @Required(value = true) private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        @Comment(value = "商品类别编号") @Required(value = true) private String categoryId;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        @Comment(value = "商品名") @Required(value = true) private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "商品价格(元宝)") @Required(value = true) private Integer price;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Comment(value = "会员价格(元宝)") @Required(value = true) private Integer vipPrice;

        public Integer getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(Integer vipPrice) {
            this.vipPrice = vipPrice;
        }

        @Comment(value = "钻石会员(元宝)") @Required(value = true) private Integer goldVipPrice;

        public Integer getGoldVipPrice() {
            return goldVipPrice;
        }

        public void setGoldVipPrice(Integer goldVipPrice) {
            this.goldVipPrice = goldVipPrice;
        }

        @Comment(value = "排序") @Required(value = true) private Integer reorder;

        public Integer getReorder() {
            return reorder;
        }

        public void setReorder(Integer reorder) {
            this.reorder = reorder;
        }

        @Comment(value = "商品主图(JsonArray)") @Required(value = true) private String pictures;

        public String getPictures() {
            return pictures;
        }

        public void setPictures(String pictures) {
            this.pictures = pictures;
        }

        @Comment(value = "详情(富文本)") @Required(value = true) private String detail;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
