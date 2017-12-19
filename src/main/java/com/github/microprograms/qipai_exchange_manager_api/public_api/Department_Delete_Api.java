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

@Comment(value = "部门 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.43")
public class Department_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        if (StringUtils.isBlank(req.getDepartmentId())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            conn.createStatement().executeUpdate(new DeleteSql(Department.class).where(buildFinalCondition(req)).build());
        }
        Response resp = new Response();
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Condition.build("id=", req.getDepartmentId()).toString();
    }

    public static class Req extends Request {

        @Comment(value = "部门ID")
        @Required(value = true)
        private String departmentId;

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }
    }
}
