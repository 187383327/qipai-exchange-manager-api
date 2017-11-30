package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.UUID;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.InsertSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "部门成员 - 添加")
@MicroApiAnnotation(type = "read", version = "v1.0.29")
public class DepartmentMember_Add_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            DepartmentMember obj = new DepartmentMember();
            obj.setId(UUID.randomUUID().toString());
            obj.setEnable(1);
            obj.setName(req.getName());
            obj.setDepartmentId(req.getDepartmentId());
            obj.setPhone(req.getPhone());
            obj.setEmailAddress(req.getEmailAddress());
            obj.setLoginName(req.getLoginName());
            obj.setLoginPassword(req.getLoginPassword());
            obj.setDtCreate(System.currentTimeMillis());
            conn.createStatement().executeUpdate(InsertSql.build(obj));
        }
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
