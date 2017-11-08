package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.IgniteUtils;
import com.github.microprograms.qipai_exchange_manager_api.utils.SelectSql;

@Comment(value = "商品类别 - 查询全部")
@MicroApiAnnotation(type = "read", version = "v1.0.6")
public class GoodsCategory_QueryAll_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        List<GoodsCategory> list = new ArrayList<>();
        try (Connection conn = IgniteUtils.getConnection()) {
            SelectSql selectSql = new SelectSql();
            selectSql.tableName(GoodsCategory.class.getSimpleName());
            ResultSet rs = conn.createStatement().executeQuery(selectSql.build());
            ResultSetMetaData rsMetaData = rs.getMetaData();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    json.put(rsMetaData.getColumnLabel(i), rs.getObject(i));
                }
                list.add(JSON.toJavaObject(json, GoodsCategory.class));
            }
        }
        resp.setData(list);
        return resp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(JSON.toJSONString(execute(null)));
    }

    public static class Resp extends Response {

        @Comment(value = "商品类别列表(全部)") @Required(value = true) private java.util.List<GoodsCategory> data;

        public java.util.List<GoodsCategory> getData() {
            return data;
        }

        public void setData(java.util.List<GoodsCategory> data) {
            this.data = data;
        }
    }
}
