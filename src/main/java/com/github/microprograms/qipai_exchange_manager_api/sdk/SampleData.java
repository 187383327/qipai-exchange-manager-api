package com.github.microprograms.qipai_exchange_manager_api.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Banner;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Banner_UpdateAll_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory_Add_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory_QueryAll_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory_QueryAll_Api.Resp;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Goods_Add_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Goods_UpdateAllHotWords_Api;

public class SampleData {
    public static void main(String[] args) throws Exception {
        addGoodsCategorys();
        addGoods();
        addHotWords();
        addBanners();
    }

    private static void addBanners() throws Exception {
        Banner_UpdateAll_Api.Req req = new Banner_UpdateAll_Api.Req();
        List<Banner> banners = new ArrayList<>();
        banners.add(buildBanner("url1"));
        banners.add(buildBanner("url2"));
        banners.add(buildBanner("url3"));
        req.setBanners(banners);
        Banner_UpdateAll_Api.execute(req);
    }

    private static Banner buildBanner(String url) {
        Banner banner = new Banner();
        banner.setId(UUID.randomUUID().toString());
        banner.setUrl(url);
        return banner;
    }

    private static void addHotWords() throws Exception {
        Goods_UpdateAllHotWords_Api.Req req = new Goods_UpdateAllHotWords_Api.Req();
        req.setHotWords(Arrays.asList("手机", "豆浆机", "洽洽瓜子", "除湿机", "床品四件套", "冰箱", "可口可乐", "泰国山竹", "佳能", "手机数据线"));
        Goods_UpdateAllHotWords_Api.execute(req);
    }

    private static void addGoods() throws Exception {
        String categoryId1 = queryGoodsCategoryByName("手机数码").getId();
        Goods_Add_Api.Req req1 = new Goods_Add_Api.Req();
        req1.setCategoryId(categoryId1);
        req1.setName("Apple iPhone 8 64GB 金色 全网通4G手机");
        req1.setStock(999);
        req1.setPrice(5600);
        req1.setVipPrice(5000);
        req1.setGoldVipPrice(4500);
        req1.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/s450x450_jfs/t9085/22/907696059/71305/93f88c62/59b85847N20776d8e.jpg")));
        req1.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req1);
    }

    private static void addGoodsCategorys() throws Exception {
        addGoodsCategory("手机数码");
        addGoodsCategory("家用电器");
        addGoodsCategory("食品生鲜");
        addGoodsCategory("酒水饮料");
        addGoodsCategory("生活旅行");
    }

    private static void addGoodsCategory(String name) throws Exception {
        GoodsCategory_Add_Api.Req req = new GoodsCategory_Add_Api.Req();
        req.setName(name);
        GoodsCategory_Add_Api.execute(req);
    }

    private static GoodsCategory queryGoodsCategoryByName(String name) throws Exception {
        GoodsCategory_QueryAll_Api.Resp resp = (Resp) GoodsCategory_QueryAll_Api.execute(new Request());
        for (GoodsCategory x : resp.getData()) {
            if (name.equals(x.getName())) {
                return x;
            }
        }
        return null;
    }
}
