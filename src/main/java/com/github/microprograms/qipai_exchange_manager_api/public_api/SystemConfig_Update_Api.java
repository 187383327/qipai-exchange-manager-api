package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "系统配置 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.54")
public class SystemConfig_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (req.getVipLevelUpConditionCommonVip() != null) {
                fields.add(new FieldToUpdate("vipLevelUpConditionCommonVip", req.getVipLevelUpConditionCommonVip()));
            }
            if (req.getVipLevelUpConditionGoldVip() != null) {
                fields.add(new FieldToUpdate("vipLevelUpConditionGoldVip", req.getVipLevelUpConditionGoldVip()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(SystemConfig.class).fields(fields).build());
        }
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "会员升级条件 - 普通会员")
        @Required(value = false)
        private Integer vipLevelUpConditionCommonVip;

        public Integer getVipLevelUpConditionCommonVip() {
            return vipLevelUpConditionCommonVip;
        }

        public void setVipLevelUpConditionCommonVip(Integer vipLevelUpConditionCommonVip) {
            this.vipLevelUpConditionCommonVip = vipLevelUpConditionCommonVip;
        }

        @Comment(value = "会员升级条件 - 钻石会员")
        @Required(value = false)
        private Integer vipLevelUpConditionGoldVip;

        public Integer getVipLevelUpConditionGoldVip() {
            return vipLevelUpConditionGoldVip;
        }

        public void setVipLevelUpConditionGoldVip(Integer vipLevelUpConditionGoldVip) {
            this.vipLevelUpConditionGoldVip = vipLevelUpConditionGoldVip;
        }
    }
}
