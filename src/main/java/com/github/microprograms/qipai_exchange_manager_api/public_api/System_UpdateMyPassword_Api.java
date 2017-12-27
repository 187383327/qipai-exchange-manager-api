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
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "系统 - 修改我的密码")
@MicroApiAnnotation(type = "read", version = "v1.0.59")
public class System_UpdateMyPassword_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        if (StringUtils.isBlank(req.getToken())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        if (!departmentMember.getLoginPassword().equals(req.getOldLoginPassword())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.loginName_loginPassword_not_match);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = Condition.build("id=", departmentMember.getId()).toString();
            List<FieldToUpdate> fields = new ArrayList<>();
            fields.add(new FieldToUpdate("loginPassword", req.getNewLoginPassword()));
            conn.createStatement().executeUpdate(new UpdateSql(DepartmentMember.class).fields(fields).where(finalCondition).build());
        }
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "Token")
        @Required(value = true)
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Comment(value = "旧的登录密码")
        @Required(value = true)
        private String oldLoginPassword;

        public String getOldLoginPassword() {
            return oldLoginPassword;
        }

        public void setOldLoginPassword(String oldLoginPassword) {
            this.oldLoginPassword = oldLoginPassword;
        }

        @Comment(value = "新的登录密码")
        @Required(value = true)
        private String newLoginPassword;

        public String getNewLoginPassword() {
            return newLoginPassword;
        }

        public void setNewLoginPassword(String newLoginPassword) {
            this.newLoginPassword = newLoginPassword;
        }
    }
}
