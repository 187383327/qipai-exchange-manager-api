package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.PagerRequest;
import com.github.microprograms.ignite_utils.sql.dml.PagerResponse;
import com.github.microprograms.ignite_utils.sql.dml.SelectCountSql;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Sort;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "用户 - 查询我的邀请列表")
@MicroApiAnnotation(type = "read", version = "v1.0.65")
public class User_QueryFollowerList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        PagerRequest pagerRequest = new PagerRequest(req.getPageIndex(), req.getPageSize());
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(User.class).where(finalCondition).pager(pagerRequest).sorts(Sort.desc("dtCreate")).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, User.class));
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(User.class).where(finalCondition).build());
            resp.setPager(new PagerResponse(pagerRequest, IgniteUtils.getCount(selectCountRs)));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        String userId = req.getUserId();
        Condition myLeaderId = null;
        switch(req.getLevel()) {
            case 1:
                myLeaderId = Condition.build("myLeaderId=", userId);
                break;
            case 2:
                myLeaderId = Condition.build("myLeaderId1=", userId);
                break;
            case 3:
                myLeaderId = Condition.build("myLeaderId2=", userId);
                break;
            default:
                myLeaderId = Condition.build("myLeaderId=", userId);
                break;
        }
        return Where.and(myLeaderId).toString();
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

        @Comment(value = "页码(从0开始)")
        @Required(value = true)
        private Integer pageIndex;

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        @Comment(value = "页大小")
        @Required(value = true)
        private Integer pageSize;

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        @Comment(value = "用户ID")
        @Required(value = false)
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Comment(value = "等级(1一级,2二级,3三级)")
        @Required(value = false)
        private Integer level;

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "我的邀请列表")
        @Required(value = true)
        private java.util.List<User> data;

        public java.util.List<User> getData() {
            return data;
        }

        public void setData(java.util.List<User> data) {
            this.data = data;
        }

        @Comment(value = "分页")
        @Required(value = true)
        private com.github.microprograms.ignite_utils.sql.dml.PagerResponse pager;

        public com.github.microprograms.ignite_utils.sql.dml.PagerResponse getPager() {
            return pager;
        }

        public void setPager(com.github.microprograms.ignite_utils.sql.dml.PagerResponse pager) {
            this.pager = pager;
        }
    }
}
