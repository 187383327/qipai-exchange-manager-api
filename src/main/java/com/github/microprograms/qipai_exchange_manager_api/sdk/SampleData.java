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
import com.github.microprograms.qipai_exchange_manager_api.public_api.RoomCard_Add_Api;

public class SampleData {
    public static void main(String[] args) throws Exception {
        addGoodsCategorys();
        addGoodsForPhone();
        addGoodsForDomesticAppliance();
        addGoodsForFood();
        addHotWords();
        addBanners();
        addRoomCards();
    }

    private static void addRoomCards() throws Exception {
        RoomCard_Add_Api.Req req1 = new RoomCard_Add_Api.Req();
        req1.setName("30元房卡");
        req1.setPrice(30);
        req1.setGoldCoin(30);
        RoomCard_Add_Api.execute(req1);

        RoomCard_Add_Api.Req req2 = new RoomCard_Add_Api.Req();
        req2.setName("50元房卡");
        req2.setPrice(50);
        req2.setGoldCoin(50);
        RoomCard_Add_Api.execute(req2);

        RoomCard_Add_Api.Req req3 = new RoomCard_Add_Api.Req();
        req3.setName("100元房卡");
        req3.setPrice(100);
        req3.setGoldCoin(100);
        RoomCard_Add_Api.execute(req3);

        RoomCard_Add_Api.Req req4 = new RoomCard_Add_Api.Req();
        req4.setName("200元房卡");
        req4.setPrice(200);
        req4.setGoldCoin(200);
        RoomCard_Add_Api.execute(req4);
    }

    private static void addBanners() throws Exception {
        Banner_UpdateAll_Api.Req req = new Banner_UpdateAll_Api.Req();
        List<Banner> banners = new ArrayList<>();
        banners.add(buildBanner(1, "http://47.104.17.187/micro-file-server/1b04a7b5-3773-4fba-9fde-90ab4e56353e.jpg"));
        banners.add(buildBanner(2, "http://47.104.17.187/micro-file-server/b525089d-4429-4fd0-8d94-7e987ff99341.jpg"));
        banners.add(buildBanner(3, "http://47.104.17.187/micro-file-server/4348aa6c-30b7-4ffd-b023-41963b5e3257.jpg"));
        req.setBanners(banners);
        Banner_UpdateAll_Api.execute(req);
    }

    private static Banner buildBanner(int reorder, String url) {
        Banner banner = new Banner();
        banner.setId(UUID.randomUUID().toString());
        banner.setReorder(reorder);
        banner.setUrl(url);
        return banner;
    }

    private static void addHotWords() throws Exception {
        Goods_UpdateAllHotWords_Api.Req req = new Goods_UpdateAllHotWords_Api.Req();
        req.setHotWords(Arrays.asList("手机", "豆浆机", "洽洽瓜子", "除湿机", "床品四件套", "冰箱", "可口可乐", "泰国山竹", "佳能", "手机数据线"));
        Goods_UpdateAllHotWords_Api.execute(req);
    }

    private static void addGoodsForPhone() throws Exception {
        String categoryId = queryGoodsCategoryByName("手机数码").getId();

        Goods_Add_Api.Req req1 = new Goods_Add_Api.Req();
        req1.setCategoryId(categoryId);
        req1.setName("Apple iPhone 8 64GB 金色 全网通4G手机");
        req1.setStock(999);
        req1.setPrice(5600);
        req1.setVipPrice(5000);
        req1.setGoldVipPrice(4500);
        req1.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/s450x450_jfs/t9085/22/907696059/71305/93f88c62/59b85847N20776d8e.jpg")));
        req1.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req1);

        Goods_Add_Api.Req req2 = new Goods_Add_Api.Req();
        req2.setCategoryId(categoryId);
        req2.setName("优它 YOTA YotaPhone2 俄罗斯双屏水墨屏智能手机电话 国礼手机 正品保证");
        req2.setStock(999);
        req2.setPrice(3400);
        req2.setVipPrice(3000);
        req2.setGoldVipPrice(2500);
        req2.setPictures(JSON.toJSONString(Arrays.asList("https://img12.360buyimg.com/n1/s450x450_jfs/t4036/222/34888999/70223/aa81730b/58390f1dN558d5940.jpg")));
        req2.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req2);

        Goods_Add_Api.Req req3 = new Goods_Add_Api.Req();
        req3.setCategoryId(categoryId);
        req3.setName("亚奥星 迷你三防手机 军工老人手机 超小电霸路虎户外长待机 双卡双待移动联通 黑色");
        req3.setStock(999);
        req3.setPrice(500);
        req3.setVipPrice(450);
        req3.setGoldVipPrice(400);
        req3.setPictures(JSON.toJSONString(Arrays.asList("http://img13.360buyimg.com/n1/s450x450_jfs/t13945/189/147124321/61733/584f84c1/5a0478ffN9ac6edb1.jpg")));
        req3.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req3);

        Goods_Add_Api.Req req4 = new Goods_Add_Api.Req();
        req4.setCategoryId(categoryId);
        req4.setName("黑莓（BlackBerry） 【全球购】BlackBerry/黑莓 Q10手机 黑色");
        req4.setStock(999);
        req4.setPrice(1000);
        req4.setVipPrice(950);
        req4.setGoldVipPrice(900);
        req4.setPictures(JSON.toJSONString(Arrays.asList("http://img13.360buyimg.com/n5/s450x450_jfs/t3181/363/6439995132/73170/fc296ee1/58a6a68fN23fa0310.jpg")));
        req4.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req4);

        Goods_Add_Api.Req req5 = new Goods_Add_Api.Req();
        req5.setCategoryId(categoryId);
        req5.setName("金柏利 001 移动/联通 双卡双待金属超薄卡片手机 学生儿童迷你小手机 黑色");
        req5.setStock(999);
        req5.setPrice(500);
        req5.setVipPrice(450);
        req5.setGoldVipPrice(400);
        req5.setPictures(JSON.toJSONString(Arrays.asList("http://img11.360buyimg.com/n1/s450x450_jfs/t5281/145/77907999/147814/21568a1e/58f840aaNe7ccf8fc.jpg")));
        req5.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req5);
    }

    private static void addGoodsForDomesticAppliance() throws Exception {
        String categoryId = queryGoodsCategoryByName("家用电器").getId();

        Goods_Add_Api.Req req1 = new Goods_Add_Api.Req();
        req1.setCategoryId(categoryId);
        req1.setName("苏泊尔（SUPOR） 不粘炒锅三件套厨具燃气锅具套装 橙色 TP1612E");
        req1.setStock(999);
        req1.setPrice(239);
        req1.setVipPrice(219);
        req1.setGoldVipPrice(209);
        req1.setPictures(JSON.toJSONString(Arrays.asList("https://img14.360buyimg.com/n1/jfs/t6037/223/6817942242/393538/598f1ed6/5976fa3fN4d96c64b.jpg")));
        req1.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req1);

        Goods_Add_Api.Req req2 = new Goods_Add_Api.Req();
        req2.setCategoryId(categoryId);
        req2.setName("苏泊尔（SUPOR）电饭煲电饭锅5L大容量 火旋风球釜内胆CFXB50FC832-75");
        req2.setStock(999);
        req2.setPrice(369);
        req2.setVipPrice(359);
        req2.setGoldVipPrice(349);
        req2.setPictures(JSON.toJSONString(Arrays.asList("https://img14.360buyimg.com/n1/jfs/t3298/271/4216356238/300371/ecfe1808/583b8b98N636caba9.jpg")));
        req2.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req2);

        Goods_Add_Api.Req req3 = new Goods_Add_Api.Req();
        req3.setCategoryId(categoryId);
        req3.setName("洁雅杰盘子 陶瓷汤盘(8英寸)纯白深盘 6只装");
        req3.setStock(999);
        req3.setPrice(36);
        req3.setVipPrice(26);
        req3.setGoldVipPrice(16);
        req3.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t3850/312/962278155/264920/3a40c2c4/581ffb02Nd1e0cbc7.jpg")));
        req3.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req3);

        Goods_Add_Api.Req req4 = new Goods_Add_Api.Req();
        req4.setCategoryId(categoryId);
        req4.setName("王麻子 刀具套装 厨房菜刀 步步高升6件套刀 DD51");
        req4.setStock(999);
        req4.setPrice(299);
        req4.setVipPrice(289);
        req4.setGoldVipPrice(279);
        req4.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t3001/278/1256167307/289997/572ed0e2/57c0112cN3f9db356.jpg")));
        req4.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req4);

        Goods_Add_Api.Req req5 = new Goods_Add_Api.Req();
        req5.setCategoryId(categoryId);
        req5.setName("新桥 双层不锈钢焊边防烫汤碗10个套装 13cm");
        req5.setStock(999);
        req5.setPrice(73);
        req5.setVipPrice(63);
        req5.setGoldVipPrice(53);
        req5.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t3145/277/3214881006/429177/24f78180/57ee434dN7bb2facb.jpg")));
        req5.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req5);

        Goods_Add_Api.Req req6 = new Goods_Add_Api.Req();
        req6.setCategoryId(categoryId);
        req6.setName("美厨（maxcook）筷子 加厚不锈钢 10双盒装 MCPJ-GK10B 防滑 防烫 耐摔");
        req6.setStock(999);
        req6.setPrice(15);
        req6.setVipPrice(10);
        req6.setGoldVipPrice(5);
        req6.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t2209/178/1743188891/278290/36e6b1/5672b402N54afbfae.jpg")));
        req6.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req6);

        Goods_Add_Api.Req req7 = new Goods_Add_Api.Req();
        req7.setCategoryId(categoryId);
        req7.setName("拜格BAYCO双层沥水架 家用多功能厨具碗碟架BX3826");
        req7.setStock(999);
        req7.setPrice(59);
        req7.setVipPrice(49);
        req7.setGoldVipPrice(39);
        req7.setPictures(JSON.toJSONString(Arrays.asList("https://img11.360buyimg.com/n1/jfs/t2530/164/1143342025/237405/d6e2d144/568f4bedNa1a36a96.jpg")));
        req7.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req7);

        Goods_Add_Api.Req req8 = new Goods_Add_Api.Req();
        req8.setCategoryId(categoryId);
        req8.setName("壳氏唯（HUSKS WARE） 稻壳菜板不发霉 纳米砧板 环保切菜板 水果案板占板易清洗 中号升级款(适合2-5人家庭约39*27cm)");
        req8.setStock(999);
        req8.setPrice(249);
        req8.setVipPrice(239);
        req8.setGoldVipPrice(229);
        req8.setPictures(JSON.toJSONString(Arrays.asList("https://img14.360buyimg.com/n1/jfs/t6049/125/3873829600/291794/e067fa7b/595b49dbN2ea03bb3.jpg")));
        req8.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req8);

        Goods_Add_Api.Req req9 = new Goods_Add_Api.Req();
        req9.setCategoryId(categoryId);
        req9.setName("苏泊尔（SUPOR） 304不锈钢蒸锅28cm双层复底汤锅二层蒸笼电磁炉锅具SZ28B5");
        req9.setStock(999);
        req9.setPrice(159);
        req9.setVipPrice(149);
        req9.setGoldVipPrice(139);
        req9.setPictures(JSON.toJSONString(Arrays.asList("https://img14.360buyimg.com/n1/jfs/t6376/342/968377821/192489/69923e59/59488f1bN53fe3f72.jpg")));
        req9.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req9);

        Goods_Add_Api.Req req10 = new Goods_Add_Api.Req();
        req10.setCategoryId(categoryId);
        req10.setName("铂帝斯（BODEUX） 铂帝斯 304不锈钢盆4件套 调料盆洗菜盆 味斗盆多功能料理盆");
        req10.setStock(999);
        req10.setPrice(179);
        req10.setVipPrice(169);
        req10.setGoldVipPrice(159);
        req10.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t5902/27/114844914/213731/1bbe26a2/592517eaN0e8fdf6b.jpg")));
        req10.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req10);

        Goods_Add_Api.Req req11 = new Goods_Add_Api.Req();
        req11.setCategoryId(categoryId);
        req11.setName("壳氏唯（HUSKS WARE） 壳氏唯稻壳筷子套装家用 无漆无蜡无异味不发霉 经典四方筷(2双装手工打磨)");
        req11.setStock(999);
        req11.setPrice(29);
        req11.setVipPrice(19);
        req11.setGoldVipPrice(9);
        req11.setPictures(JSON.toJSONString(Arrays.asList("https://img11.360buyimg.com/n1/jfs/t8068/201/1479891310/433015/a418b73/59ba26d2N2c22a814.jpg")));
        req11.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req11);

        Goods_Add_Api.Req req12 = new Goods_Add_Api.Req();
        req12.setCategoryId(categoryId);
        req12.setName("煎蛋模【款式随机】");
        req12.setStock(999);
        req12.setPrice(9);
        req12.setVipPrice(7);
        req12.setGoldVipPrice(5);
        req12.setPictures(JSON.toJSONString(Arrays.asList("https://img11.360buyimg.com/n1/jfs/t2287/359/1993093377/43724/119b5817/56e917c4N0f2d73b8.jpg")));
        req12.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req12);

        Goods_Add_Api.Req req13 = new Goods_Add_Api.Req();
        req13.setCategoryId(categoryId);
        req13.setName("食品级硅胶铲");
        req13.setStock(999);
        req13.setPrice(39);
        req13.setVipPrice(29);
        req13.setGoldVipPrice(19);
        req13.setPictures(JSON.toJSONString(Arrays.asList("https://img12.360buyimg.com/n1/jfs/t4585/45/2112776157/82837/273ce2be/59190b05N5cdb7430.jpg")));
        req13.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req13);

        Goods_Add_Api.Req req14 = new Goods_Add_Api.Req();
        req14.setCategoryId(categoryId);
        req14.setName("海绵擦【颜色随机，款式随机】");
        req14.setStock(999);
        req14.setPrice(9);
        req14.setVipPrice(7);
        req14.setGoldVipPrice(5);
        req14.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t6973/301/474205166/172285/698f85c7/5976e972N960e5d56.jpg")));
        req14.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req14);

        Goods_Add_Api.Req req15 = new Goods_Add_Api.Req();
        req15.setCategoryId(categoryId);
        req15.setName("小熊（Bear）电炖锅 紫砂锅汤煮粥锅自动燕窝隔水电炖盅DDZ-A25Z1 2.5L");
        req15.setStock(999);
        req15.setPrice(229);
        req15.setVipPrice(219);
        req15.setGoldVipPrice(209);
        req15.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t3667/211/238057207/252527/cbc413c6/580444d7N5822b038.jpg")));
        req15.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req15);

        Goods_Add_Api.Req req16 = new Goods_Add_Api.Req();
        req16.setCategoryId(categoryId);
        req16.setName("蓓慈(BEICI)BZ501C全自动按摩足浴盆洗脚盆泡脚盆泡脚桶");
        req16.setStock(999);
        req16.setPrice(329);
        req16.setVipPrice(319);
        req16.setGoldVipPrice(309);
        req16.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t3394/182/1991303904/67061/e1a0aa0e/5837f8eeN49c95dac.jpg")));
        req16.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req16);

        Goods_Add_Api.Req req17 = new Goods_Add_Api.Req();
        req17.setCategoryId(categoryId);
        req17.setName("欧井（Eurgeen）除湿机/抽湿机 除湿量9升/天 适用面积5-20平方米 噪音36分贝 家用地下室静音净化干衣吸湿器 OJ-161E");
        req17.setStock(999);
        req17.setPrice(699);
        req17.setVipPrice(689);
        req17.setGoldVipPrice(679);
        req17.setPictures(JSON.toJSONString(Arrays.asList("https://img12.360buyimg.com/n1/jfs/t13471/67/268586315/90054/27e6b692/5a07a986N8a4f3f53.jpg")));
        req17.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req17);
    }

    private static void addGoodsForFood() throws Exception {
        String categoryId = queryGoodsCategoryByName("食品生鲜").getId();

        Goods_Add_Api.Req req1 = new Goods_Add_Api.Req();
        req1.setCategoryId(categoryId);
        req1.setName("百花 新鲜王浆蜂王浆450g 顺丰航空加冰 保证新鲜 【中华老字号】");
        req1.setStock(999);
        req1.setPrice(249);
        req1.setVipPrice(239);
        req1.setGoldVipPrice(229);
        req1.setPictures(JSON.toJSONString(Arrays.asList("https://img12.360buyimg.com/n1/jfs/t5719/189/278700984/261407/b8e0b68f/591e745dNd9ccaa5f.jpg")));
        req1.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req1);

        Goods_Add_Api.Req req2 = new Goods_Add_Api.Req();
        req2.setCategoryId(categoryId);
        req2.setName("东阿阿胶 阿胶片阿胶块250g 红标铁盒装");
        req2.setStock(999);
        req2.setPrice(1350);
        req2.setVipPrice(1250);
        req2.setGoldVipPrice(1150);
        req2.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t5167/13/411963192/119843/f3bf3d7d/58ff0fe7Nd9cbdfcc.jpg")));
        req2.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req2);

        Goods_Add_Api.Req req3 = new Goods_Add_Api.Req();
        req3.setCategoryId(categoryId);
        req3.setName("云南白药三七粉 豹七牌 三七超细粉 三七粉 260g");
        req3.setStock(999);
        req3.setPrice(248);
        req3.setVipPrice(238);
        req3.setGoldVipPrice(228);
        req3.setPictures(JSON.toJSONString(Arrays.asList("https://img11.360buyimg.com/n1/jfs/t4654/121/2213302771/330019/390fdb32/58ec98a0Nd96add03.jpg")));
        req3.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req3);

        Goods_Add_Api.Req req4 = new Goods_Add_Api.Req();
        req4.setCategoryId(categoryId);
        req4.setName("靠山庄 【破损包赔】特大5-8支半斤装 6年根新鲜人参东北长白山野山参礼盒泡酒搭配皂苷 半斤装");
        req4.setStock(999);
        req4.setPrice(95);
        req4.setVipPrice(85);
        req4.setGoldVipPrice(75);
        req4.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t10789/22/1668150998/792429/45742bb5/59e4dbd0N537cf038.jpg")));
        req4.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req4);

        Goods_Add_Api.Req req5 = new Goods_Add_Api.Req();
        req5.setCategoryId(categoryId);
        req5.setName("青源堂 冬虫夏草5条/g 青海玉树高海拔虫草");
        req5.setStock(999);
        req5.setPrice(189);
        req5.setVipPrice(179);
        req5.setGoldVipPrice(169);
        req5.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t5770/120/5285506332/266858/a160b64a/595ca898Na233663d.jpg")));
        req5.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req5);

        Goods_Add_Api.Req req6 = new Goods_Add_Api.Req();
        req6.setCategoryId(categoryId);
        req6.setName("天下泽雨 霍山石斛鲜条 新鲜石斛鲜条礼盒 三年仿野生霍山米斛 50g");
        req6.setStock(999);
        req6.setPrice(240);
        req6.setVipPrice(230);
        req6.setGoldVipPrice(220);
        req6.setPictures(JSON.toJSONString(Arrays.asList("https://img13.360buyimg.com/n1/jfs/t10144/67/2342258982/330252/673fc943/59f45546N541defaf.jpg")));
        req6.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req6);

        Goods_Add_Api.Req req7 = new Goods_Add_Api.Req();
        req7.setCategoryId(categoryId);
        req7.setName("御丝燕 马来西亚燕窝 6A官燕盏 孕妇老年人儿童燕窝盏 滋补补品 燕窝礼盒 20克【送滋补八件套+炖具一套】");
        req7.setStock(999);
        req7.setPrice(240);
        req7.setVipPrice(230);
        req7.setGoldVipPrice(220);
        req7.setPictures(JSON.toJSONString(Arrays.asList("https://img10.360buyimg.com/n1/jfs/t9724/241/374601438/197731/d13db74d/59cdbf40N2a4f2497.jpg")));
        req7.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req7);

        Goods_Add_Api.Req req8 = new Goods_Add_Api.Req();
        req8.setCategoryId(categoryId);
        req8.setName("沂源苹果（Yiyuan Apple）泰国进口金枕头榴莲水果约2.5-3.5kg");
        req8.setStock(999);
        req8.setPrice(240);
        req8.setVipPrice(230);
        req8.setGoldVipPrice(220);
        req8.setPictures(JSON.toJSONString(Arrays.asList("https://img11.360buyimg.com/n1/jfs/t5851/56/9123571032/303833/d234e010/5982cb1fNc0786acb.jpg")));
        req8.setDetail("这里是详情(富文本)");
        Goods_Add_Api.execute(req8);
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
