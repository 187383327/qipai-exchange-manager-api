package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "部门成员 - 删除")
@MicroApiAnnotation(type = "read", version = "v1.0.20")
public class DepartmentMember_Delete_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
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
