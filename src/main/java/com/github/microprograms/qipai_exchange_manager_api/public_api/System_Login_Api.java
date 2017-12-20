package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.FieldToUpdate;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.UpdateSql;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "系统 - 登录")
@MicroApiAnnotation(type = "read", version = "v1.0.46")
public class System_Login_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        if (StringUtils.isBlank(req.getLoginName()) || StringUtils.isBlank(req.getLoginPassword())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(DepartmentMember.class).where(finalCondition).build());
            DepartmentMember departmentMember = IgniteUtils.getJavaObject(selectRs, DepartmentMember.class);
            if (departmentMember == null) {
                throw new MicroApiExecuteException(ErrorCodeEnum.loginName_loginPassword_not_match);
            }
            String newToken = UUID.randomUUID().toString();
            updateToken(departmentMember.getId(), newToken);
            departmentMember.setToken(newToken);
            resp.setData(departmentMember);
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        Condition loginName = Condition.build("loginName=", req.getLoginName());
        Condition loginPassword = Condition.build("loginPassword=", req.getLoginPassword());
        return Where.and(loginName, loginPassword).toString();
    }

    private static int updateToken(String id, String token) throws SQLException {
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<FieldToUpdate> fields = new ArrayList<>();
            fields.add(new FieldToUpdate("token", token));
            Condition finalCondition = Condition.build("id=", id);
            return conn.createStatement().executeUpdate(new UpdateSql(DepartmentMember.class).fields(fields).where(finalCondition).build());
        }
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
