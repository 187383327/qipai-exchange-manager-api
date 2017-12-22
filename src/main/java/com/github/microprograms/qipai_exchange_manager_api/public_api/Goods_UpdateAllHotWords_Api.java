package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.UUID;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.DeleteSql;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.public_api.Banner_QueryAll_Api.Resp;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品/优选商品 - 更新全部搜索热点词")
@MicroApiAnnotation(type = "read", version = "v1.0.55")
public class Goods_UpdateAllHotWords_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            conn.createStatement().executeUpdate(new DeleteSql(HotWord.class).build());
            for (int i = 0; i < req.getHotWords().size(); i++) {
                HotWord obj = new HotWord();
                obj.setId(UUID.randomUUID().toString());
                obj.setHotWord(req.getHotWords().get(i));
                obj.setReorder(i + 1);
                conn.createStatement().executeUpdate(InsertSql.build(obj));
            }
        }
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "搜索热点词列表(全部)")
        @Required(value = true)
        private java.util.List<String> hotWords;

        public java.util.List<String> getHotWords() {
            return hotWords;
        }

        public void setHotWords(java.util.List<String> hotWords) {
            this.hotWords = hotWords;
        }
    }
}
