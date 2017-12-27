package com.github.microprograms.qipai_exchange_manager_api.sdk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.qipai_exchange_core.model.Banner;
import com.github.microprograms.qipai_exchange_core.model.GiftPack;
import com.github.microprograms.qipai_exchange_core.model.GiftPackBuyHistory;
import com.github.microprograms.qipai_exchange_core.model.GoodsCategory;
import com.github.microprograms.qipai_exchange_core.model.GoodsOrderItem;
import com.github.microprograms.qipai_exchange_core.model.HotWord;
import com.github.microprograms.qipai_exchange_core.model.ImageText;
import com.github.microprograms.qipai_exchange_core.model.MixOrder;
import com.github.microprograms.qipai_exchange_core.model.NewStock;
import com.github.microprograms.qipai_exchange_core.model.Permission;
import com.github.microprograms.qipai_exchange_core.model.RoomCard;
import com.github.microprograms.qipai_exchange_core.model.SystemConfig;
import com.github.microprograms.qipai_exchange_core.model.User;
import com.github.microprograms.qipai_exchange_core.model.UserAddr;
import com.github.microprograms.qipai_exchange_core.model.WalletBill;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Department;
import com.github.microprograms.qipai_exchange_manager_api.public_api.DepartmentMember;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Goods;
import com.github.microprograms.qipai_exchange_manager_api.public_api.WithdrawCash;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;

public class BackupDatabase {
    public static void main(String[] args) throws Exception {
        List<Class<?>> list = new ArrayList<>();
        list.add(GoodsCategory.class);
        list.add(Goods.class);
        list.add(RoomCard.class);
        list.add(MixOrder.class);
        list.add(GoodsOrderItem.class);
        list.add(NewStock.class);
        list.add(Banner.class);
        list.add(ImageText.class);
        list.add(HotWord.class);
        list.add(WithdrawCash.class);
        list.add(User.class);
        list.add(UserAddr.class);
        list.add(WalletBill.class);
        list.add(Department.class);
        list.add(DepartmentMember.class);
        list.add(Permission.class);
        list.add(GiftPack.class);
        list.add(GiftPackBuyHistory.class);
        list.add(SystemConfig.class);
        write(list);
    }

    private static <T> void write(List<Class<?>> list) throws SQLException, IOException {
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File dir = new File(String.format("backup/%s/", time));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (Class<?> x : list) {
            String json = JSON.toJSONString(queryAll(x));
            OutputStream output = new FileOutputStream(new File(dir, String.format("%s.json", x.getSimpleName())));
            try {
                IOUtils.write(json, output, "utf8");
            } finally {
                IOUtils.closeQuietly(output);
            }
        }
    }

    private static <T> List<T> queryAll(Class<T> clz) throws SQLException {
        return Commons.queryAllObject(clz, null);
    }
}
