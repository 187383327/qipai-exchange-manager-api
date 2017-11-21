package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "部门 - 更新")
@MicroApiAnnotation(type = "read", version = "v1.0.20")
public class Department_Update_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Response resp = new Response();
        return resp;
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

        @Comment(value = "部门名称")
        @Required(value = true)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Comment(value = "职能描述")
        @Required(value = true)
        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Comment(value = "权限列表(JsonArray)")
        @Required(value = true)
        private String permissions;

        public String getPermissions() {
            return permissions;
        }

        public void setPermissions(String permissions) {
            this.permissions = permissions;
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
