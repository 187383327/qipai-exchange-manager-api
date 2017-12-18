package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "部门成员 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.39")
public class DepartmentMember_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getDepartmentId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            if (StringUtils.isNoneBlank(req.getName())) {
                fields.add(new FieldToUpdate("name", req.getName()));
            }
            if (StringUtils.isNoneBlank(req.getDepartmentId())) {
                fields.add(new FieldToUpdate("departmentId", req.getDepartmentId()));
            }
            if (StringUtils.isNoneBlank(req.getPhone())) {
                fields.add(new FieldToUpdate("phone", req.getPhone()));
            }
            if (StringUtils.isNoneBlank(req.getEmailAddress())) {
                fields.add(new FieldToUpdate("emailAddress", req.getEmailAddress()));
            }
            if (StringUtils.isNoneBlank(req.getLoginName())) {
                fields.add(new FieldToUpdate("loginName", req.getLoginName()));
            }
            if (StringUtils.isNoneBlank(req.getLoginPassword())) {
                fields.add(new FieldToUpdate("loginPassword", req.getLoginPassword()));
            }
            if (req.getEnable() != null) {
                fields.add(new FieldToUpdate("enable", req.getEnable()));
            }
            conn.createStatement().executeUpdate(new UpdateSql(DepartmentMember.class).fields(fields).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getDepartmentId()).toString();
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

        @Comment(value = "是否启用(0否1是)")
        @Required(value = true)
        private Integer enable;

        public Integer getEnable() {
            return enable;
        }

        public void setEnable(Integer enable) {
            this.enable = enable;
        }
    }
}
