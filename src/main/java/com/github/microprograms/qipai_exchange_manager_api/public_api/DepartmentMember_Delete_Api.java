package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.DeleteSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "部门成员 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.44")
public class DepartmentMember_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getDepartmentMemberId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            conn.createStatement().executeUpdate(new DeleteSql(DepartmentMember.class).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getDepartmentMemberId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "部门成员ID")
        @Required(value = true)
        private String departmentMemberId;

        public String getDepartmentMemberId() {
            return departmentMemberId;
        }

        public void setDepartmentMemberId(String departmentMemberId) {
            this.departmentMemberId = departmentMemberId;
        }
    }
}
