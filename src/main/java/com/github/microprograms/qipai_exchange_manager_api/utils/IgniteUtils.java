package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
