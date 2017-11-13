package com.github.microprograms.qipai_exchange_manager_api.sdk;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Banner_UpdateAll_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory_Add_Api;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Goods_UpdateAllHotWords_Api;

public class SampleData {
    public static void main(String[] args) throws Exception {
        Goods_UpdateAllHotWords_Api.execute(JSON.parseObject("{ \"hotWords\": [ \"手机\", \"豆浆机\", \"洽洽瓜子\", \"除湿机\", \"床品四件套\", \"冰箱\", \"可口可乐\", \"泰国山竹\", \"佳能\", \"手机数据线\" ] }", Goods_UpdateAllHotWords_Api.Req.class));

        Banner_UpdateAll_Api.execute(JSON.parseObject("{ \"banners\": [ { \"reorder\": \"1\", \"url\": \"url1\" }, { \"reorder\": \"2\", \"url\": \"url2\" }, { \"reorder\": \"3\", \"url\": \"url3\" }, { \"reorder\": \"4\", \"url\": \"url4\" }, { \"reorder\": \"5\", \"url\": \"url5\" } ] }", Banner_UpdateAll_Api.Req.class));

        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"name\": \"手机数码\" }", GoodsCategory_Add_Api.Req.class));
        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"name\": \"家用电器\" }", GoodsCategory_Add_Api.Req.class));
        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"name\": \"食品生鲜\" }", GoodsCategory_Add_Api.Req.class));
        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"name\": \"酒水饮料\" }", GoodsCategory_Add_Api.Req.class));
        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"name\": \"生活旅行\" }", GoodsCategory_Add_Api.Req.class));
    }
}
