package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "系统配置 - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.59")
public class SystemConfig_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(SystemConfig.class).build());
            resp.setData(IgniteUtils.getJavaObject(selectRs, SystemConfig.class));
        }
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "系统配置")
        @Required(value = true)
        private SystemConfig data;

        public SystemConfig getData() {
            return data;
        }

        public void setData(SystemConfig data) {
            this.data = data;
        }
    }
}
