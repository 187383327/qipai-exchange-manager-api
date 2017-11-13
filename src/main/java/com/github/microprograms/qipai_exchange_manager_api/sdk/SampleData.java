package com.github.microprograms.qipai_exchange_manager_api.sdk;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.qipai_exchange_manager_api.public_api.GoodsCategory_Add_Api;

public class SampleData {
    public static void main(String[] args) throws Exception {
        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"Banner_UpdateAll_Api\", \"banners\": [ { \"reorder\": \"1\", \"url\": \"url1\" }, { \"reorder\": \"2\", \"url\": \"url2\" }, { \"reorder\": \"3\", \"url\": \"url3\" }, { \"reorder\": \"4\", \"url\": \"url4\" }, { \"reorder\": \"5\", \"url\": \"url5\" } ] }", GoodsCategory_Add_Api.Req.class));
        
//        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"GoodsCategory_Add_Api\", \"name\": \"手机数码\" }", GoodsCategory_Add_Api.Req.class));
//        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"GoodsCategory_Add_Api\", \"name\": \"家用电器\" }", GoodsCategory_Add_Api.Req.class));
//        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"GoodsCategory_Add_Api\", \"name\": \"食品生鲜\" }", GoodsCategory_Add_Api.Req.class));
//        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"GoodsCategory_Add_Api\", \"name\": \"酒水饮料\" }", GoodsCategory_Add_Api.Req.class));
//        GoodsCategory_Add_Api.execute(JSON.parseObject("{ \"apiName\": \"GoodsCategory_Add_Api\", \"name\": \"生活旅行\" }", GoodsCategory_Add_Api.Req.class));
    }
}
