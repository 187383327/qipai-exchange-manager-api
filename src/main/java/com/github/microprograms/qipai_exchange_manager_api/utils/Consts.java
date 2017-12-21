package com.github.microprograms.qipai_exchange_manager_api.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Consts {
    public static String jdbc_url;

    static {
        Config conf = ConfigFactory.load();
        jdbc_url = conf.getString("jdbc_url");
    }
}
