package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "部门成员 - 添加")
@MicroApiAnnotation(type = "read", version = "v1.0.20")
public class DepartmentMember_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "成员姓名")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "所属部门ID")
        @Required(value = true)
        private String departmentId;

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        @Comment(value = "联系电话")
        @Required(value = true)
        private String phone;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Comment(value = "邮箱地址")
        @Required(value = true)
        private String emailAddress;

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

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
}
