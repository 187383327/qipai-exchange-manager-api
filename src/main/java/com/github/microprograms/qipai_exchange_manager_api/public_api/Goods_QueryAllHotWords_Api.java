package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Sort;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_core.model.HotWord;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品 - 查询全部搜索热点词")
@MicroApiAnnotation(type = "read", version = "v1.0.39")
public class Goods_QueryAllHotWords_Api {

    public static Response execute(Request request) throws Exception {
        Resp resp = new Resp();
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet rs = conn.createStatement().executeQuery(new SelectSql(HotWord.class).sorts(Sort.asc("reorder")).build());
            List<String> hotWords = new ArrayList<>();
            for (HotWord x : IgniteUtils.getJavaObjectList(rs, HotWord.class)) {
                hotWords.add(x.getHotWord());
            }
            resp.setData(hotWords);
        }
        return resp;
    }

    public static class Resp extends Response {

        @Comment(value = "搜索热点词列表(全部)")
        @Required(value = true)
        private java.util.List<String> data;

        public java.util.List<String> getData() {
            return data;
        }

        public void setData(java.util.List<String> data) {
            this.data = data;
        }
    }
}
