package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Department;
import com.github.microprograms.qipai_exchange_manager_api.public_api.DepartmentMember;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Goods;
import com.github.microprograms.qipai_exchange_manager_api.public_api.MixOrder;
import com.github.microprograms.qipai_exchange_manager_api.public_api.PermissionEnum;
import com.github.microprograms.qipai_exchange_manager_api.public_api.RoomCard;
import com.github.microprograms.qipai_exchange_manager_api.public_api.User;
import com.github.microprograms.qipai_exchange_manager_api.public_api.WithdrawCash;

public class Commons {
    public static <T> T queryObject(Class<T> clz, Object where) throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(clz).where(where).build());
            return IgniteUtils.getJavaObject(selectRs, clz);
        }
    }

    public static <T> List<T> queryAllObject(Class<T> clz, Object where) throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(clz).where(where).build());
            return IgniteUtils.getJavaObjectList(selectRs, clz);
        }
    }

    public static MixOrder queryMixOrderById(String orderId) throws SQLException {
        return queryObject(MixOrder.class, Condition.build("id=", orderId));
    }

    public static Goods queryGoodsById(String goodsId) throws SQLException {
        return queryObject(Goods.class, Condition.build("id=", goodsId));
    }

    public static RoomCard queryRoomCardById(String roomCardId) throws SQLException {
        return queryObject(RoomCard.class, Condition.build("id=", roomCardId));
    }

    public static User queryUserByWxUnionId(String wxUnionId) throws SQLException {
        return queryObject(User.class, Condition.build("wxUnionId=", wxUnionId));
    }

    public static User queryUserById(String userId) throws SQLException {
        return queryObject(User.class, Condition.build("id=", userId));
    }

    public static <T> int updateFieldsForObject(Class<T> clz, List<FieldToUpdate> fields, Object where) throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            return conn.createStatement().executeUpdate(new UpdateSql(clz).fields(fields).where(where).build());
        }
    }

    public static int updateMyLeaderIdForUser(String userId, String myLeaderId) throws SQLException {
        List<FieldToUpdate> fields = new ArrayList<>();
        fields.add(new FieldToUpdate("myLeaderId", myLeaderId));
        return updateFieldsForObject(User.class, fields, Condition.build("id=", userId));
    }

    public static DepartmentMember queryDepartmentMemberByToken(String token) throws SQLException {
        return queryObject(DepartmentMember.class, Condition.build("token=", token));
    }

    public static Department queryDepartmentById(String departmentId) throws SQLException {
        return queryObject(Department.class, Condition.build("id=", departmentId));
    }

    public static boolean hasPermission(Department department, PermissionEnum permission) throws SQLException {
        String permissions = department.getPermissions();
        if (StringUtils.isBlank(permissions)) {
            return false;
        }
        return JSON.parseArray(department.getPermissions()).contains(permission.getId());
    }

    public static WithdrawCash queryWithdrawCashById(String withdrawCashId) throws SQLException {
        return queryObject(WithdrawCash.class, Condition.build("id=", withdrawCashId));
    }
}
