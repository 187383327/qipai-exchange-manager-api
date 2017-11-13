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

        Goods_Add_Api.Req req2 = new Goods_Add_Api.Req();
        req2.setCategoryId(categoryId1);
        req2.setName("优它 YOTA YotaPhone2 俄罗斯双屏水墨屏智能手机电话 国礼手机 正品保证");
        req2.setStock(999);
        req2.setPrice(3400);
        req2.setVipPrice(3000);
        req2.setGoldVipPrice(2500);
        req2.setPictures(JSON.toJSONString(Arrays.asList("https://img12.360buyimg.com/n1/s450x450_jfs/t4036/222/34888999/70223/aa81730b/58390f1dN558d5940.jpg")));
        req2.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req2);

        Goods_Add_Api.Req req3 = new Goods_Add_Api.Req();
        req3.setCategoryId(categoryId1);
        req3.setName("亚奥星 迷你三防手机 军工老人手机 超小电霸路虎户外长待机 双卡双待移动联通 黑色");
        req3.setStock(999);
        req3.setPrice(500);
        req3.setVipPrice(450);
        req3.setGoldVipPrice(400);
        req3.setPictures(JSON.toJSONString(Arrays.asList("http://img13.360buyimg.com/n1/s450x450_jfs/t13945/189/147124321/61733/584f84c1/5a0478ffN9ac6edb1.jpg")));
        req3.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req3);
        
        Goods_Add_Api.Req req4 = new Goods_Add_Api.Req();
        req4.setCategoryId(categoryId1);
        req4.setName("黑莓（BlackBerry） 【全球购】BlackBerry/黑莓 Q10手机 黑色");
        req4.setStock(999);
        req4.setPrice(1000);
        req4.setVipPrice(950);
        req4.setGoldVipPrice(900);
        req4.setPictures(JSON.toJSONString(Arrays.asList("http://img13.360buyimg.com/n5/s450x450_jfs/t3181/363/6439995132/73170/fc296ee1/58a6a68fN23fa0310.jpg")));
        req4.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req4);
        
        Goods_Add_Api.Req req5 = new Goods_Add_Api.Req();
        req5.setCategoryId(categoryId1);
        req5.setName("金柏利 001 移动/联通 双卡双待金属超薄卡片手机 学生儿童迷你小手机 黑色");
        req5.setStock(999);
        req5.setPrice(500);
        req5.setVipPrice(450);
        req5.setGoldVipPrice(400);
        req5.setPictures(JSON.toJSONString(Arrays.asList("http://img11.360buyimg.com/n1/s450x450_jfs/t5281/145/77907999/147814/21568a1e/58f840aaNe7ccf8fc.jpg")));
        req5.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req5);
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
