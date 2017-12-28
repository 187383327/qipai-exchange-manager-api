package com.github.microprograms.qipai_exchange_manager_api.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Consts {
    public static String jdbc_url;
    public static String goods_detail_dir;

    static {
        Config conf = ConfigFactory.load();
        jdbc_url = conf.getString("jdbc_url");
        goods_detail_dir = conf.getString("goods_detail_dir");
    }
}
