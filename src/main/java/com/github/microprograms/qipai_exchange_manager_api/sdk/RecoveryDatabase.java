package com.github.microprograms.qipai_exchange_manager_api.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

public class RecoveryDatabase {
    public static void main(String[] args) throws Exception {
        read("backup/20171227112055");
    }

    private static void read(String dir) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
        for (File file : new File(dir).listFiles()) {
            String entityName = file.getName().replaceAll("\\..*", "");
            InputStream input = new FileInputStream(file);
            List<String> lines = IOUtils.readLines(input, "utf8");
            String json = StringUtils.join(lines, "");
            Class<?> clz = Class.forName(String.format("com.github.microprograms.qipai_exchange_core.model.%s", entityName));
            List<?> list = JSON.parseArray(json, clz);
            recovery(list);
        }
    }

    private static void recovery(List<?> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            for (Object x : list) {
                conn.createStatement().executeUpdate(InsertSql.build(x));
            }
        }
    }
}
