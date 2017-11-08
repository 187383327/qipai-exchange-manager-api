package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class IgniteUtils {
    private static final Logger log = LoggerFactory.getLogger(IgniteUtils.class);

    static {
        try {
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
        } catch (ClassNotFoundException e) {
            log.error("canot load ignite jdbc driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:ignite:thin://xzw1/public");
    }

    public static List<JSONObject> getJsonList(ResultSet rs) throws SQLException {
        List<JSONObject> list = new ArrayList<>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        while (rs.next()) {
            JSONObject json = new JSONObject();
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                json.put(rsMetaData.getColumnLabel(i), rs.getObject(i));
            }
            list.add(json);
        }
        return list;
    }

    public static <T> List<T> getJavaObjectList(ResultSet rs, Class<T> clz) throws SQLException {
        List<T> list = new ArrayList<>();
        for (JSONObject json : getJsonList(rs)) {
            list.add(JSONObject.toJavaObject(json, clz));
        }
        return list;
    }
}
