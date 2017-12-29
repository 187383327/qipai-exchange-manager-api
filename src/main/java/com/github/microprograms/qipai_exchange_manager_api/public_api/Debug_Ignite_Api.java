package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.util.ArrayList;
import org.apache.ignite.Ignite;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.IgnitionUtils;

@Comment(value = "调试 - Ignite")
@MicroApiAnnotation(type = "read", version = "v1.0.63")
public class Debug_Ignite_Api {

    public static Response execute(Request request) throws Exception {
        RespExt resp = new RespExt();
        Ignite ignite = IgnitionUtils.getIgnite();
        resp.setCacheNames(new ArrayList<>(ignite.cacheNames()));
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

        @Comment(value = "缓存名列表")
        @Required(value = true)
        private java.util.List<String> cacheNames;

        public java.util.List<String> getCacheNames() {
            return cacheNames;
        }

        public void setCacheNames(java.util.List<String> cacheNames) {
            this.cacheNames = cacheNames;
        }
    }
}
