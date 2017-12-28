package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.util.ArrayList;
import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import com.github.microprograms.ignite_utils.Metadata;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Sort;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.IgnitionUtils;

@Comment(value = "调试 - Ignite")
@MicroApiAnnotation(type = "read", version = "v1.0.61")
public class Debug_Ignite_Api {

    public static Response execute(Request request) throws Exception {
        RespExt resp = new RespExt();
        Ignite ignite = IgnitionUtils.getIgnite();
        resp.setCacheNames(new ArrayList<>(ignite.cacheNames()));
        IgniteCache<Object, Object> bannerCache = ignite.cache("SQL_PUBLIC_BANNER");
        Metadata<Banner> metadata = new Metadata<>(Banner.class);
        String finalCondition = Condition.build("type=", "1").toString();
        String sql = new SelectSql(Banner.class).fieldNames(metadata.getFieldNames()).where(finalCondition).sorts(Sort.asc("reorder")).build();
        List<Banner> list = new ArrayList<>();
        try (QueryCursor<List<?>> cursor = bannerCache.query(new SqlFieldsQuery(sql))) {
            for (List<?> row : cursor) {
                list.add(metadata.deserialize(row));
            }
        }
        resp.setIgniteCache(list);
        // try (Transaction tx = ignite.transactions().txStart()) {
        // tx.commit();
        // }
        return resp;
    }

    public static class RespExt extends Resp {
        private Object igniteCache;

        public Object getIgniteCache() {
            return igniteCache;
        }

        public void setIgniteCache(Object igniteCache) {
            this.igniteCache = igniteCache;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "缓存名列表") @Required(value = true) private java.util.List<String> cacheNames;

        public java.util.List<String> getCacheNames() {
            return cacheNames;
        }

        public void setCacheNames(java.util.List<String> cacheNames) {
            this.cacheNames = cacheNames;
        }
    }
}
