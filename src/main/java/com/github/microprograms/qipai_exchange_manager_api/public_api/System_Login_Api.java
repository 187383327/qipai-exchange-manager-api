package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "系统 - 登录")
@MicroApiAnnotation(type = "read", version = "v1.0.35")
public class System_Login_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "登录名")
        @Required(value = true)
        private String loginName;

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        @Comment(value = "登录密码")
        @Required(value = true)
        private String loginPassword;

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "个人资料详情")
        @Required(value = true)
        private DepartmentMember data;

        public DepartmentMember getData() {
            return data;
        }

        public void setData(DepartmentMember data) {
            this.data = data;
        }
    }
}
