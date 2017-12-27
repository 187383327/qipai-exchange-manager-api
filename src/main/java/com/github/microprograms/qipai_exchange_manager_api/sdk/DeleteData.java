package com.github.microprograms.qipai_exchange_manager_api.sdk;

import java.sql.Connection;
import java.sql.SQLException;

import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.DeleteSql;
import com.github.microprograms.qipai_exchange_core.model.Banner;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

public class DeleteData {
    public static void main(String[] args) throws Exception {
        // clear(MixOrder.class);
        // clear(GoodsOrderItem.class);
        // clear(User.class);
        // clear(UserAddr.class);
        // clear(WalletBill.class);
        // clear(WithdrawCash.class);
        clear(Banner.class);
    }

    private static void clear(Class<?> clz) throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            conn.createStatement().execute(new DeleteSql(clz).build());
        }
    }
}
