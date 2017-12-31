package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Sort;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "会员专区Banner - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.64")
public class ChoiceBanner_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition();
            ResultSet rs = conn.createStatement().executeQuery(new SelectSql(Banner.class).where(finalCondition).sorts(Sort.asc("reorder")).build());
            resp.setData(IgniteUtils.getJavaObjectList(rs, Banner.class));
        }
        return resp;
    }

    private static String buildFinalCondition() {
        return Condition.build("type=", "2").toString();
    }

    public static class Resp extends Response {

        @Comment(value = "Banner列表(全部)")
        @Required(value = true)
        private java.util.List<Banner> data;

        public java.util.List<Banner> getData() {
            return data;
        }

        public void setData(java.util.List<Banner> data) {
            this.data = data;
        }
    }
}
