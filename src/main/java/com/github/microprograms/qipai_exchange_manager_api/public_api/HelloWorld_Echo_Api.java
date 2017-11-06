package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "Echo")
@MicroApiAnnotation(type = "read", version = "v1.0.0")
public class HelloWorld_Echo_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "参数1")
        @Required(value = true)
        private String arg1;

        public String getArg1() {
            return arg1;
        }

        public void setArg1(String arg1) {
            this.arg1 = arg1;
        }

        @Comment(value = "参数2")
        @Required(value = false)
        private String arg2;

        public String getArg2() {
            return arg2;
        }

        public void setArg2(String arg2) {
            this.arg2 = arg2;
        }

        @Comment(value = "参数3")
        @Required(value = false)
        private Long arg3;

        public Long getArg3() {
            return arg3;
        }

        public void setArg3(Long arg3) {
            this.arg3 = arg3;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "参数1")
        @Required(value = true)
        private String arg1;

        public String getArg1() {
            return arg1;
        }

        public void setArg1(String arg1) {
            this.arg1 = arg1;
        }

        @Comment(value = "参数2")
        @Required(value = false)
        private String arg2;

        public String getArg2() {
            return arg2;
        }

        public void setArg2(String arg2) {
            this.arg2 = arg2;
        }

        @Comment(value = "参数3")
        @Required(value = false)
        private Long arg3;

        public Long getArg3() {
            return arg3;
        }

        public void setArg3(Long arg3) {
            this.arg3 = arg3;
        }
    }
}
