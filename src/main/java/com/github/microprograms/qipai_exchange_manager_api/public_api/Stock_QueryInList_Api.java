package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.commons.lang3.StringUtils;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.LikeCondition;
import com.github.microprograms.ignite_utils.sql.dml.PagerRequest;
import com.github.microprograms.ignite_utils.sql.dml.PagerResponse;
import com.github.microprograms.ignite_utils.sql.dml.SelectCountSql;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Sort;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Commons;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "库存 - 查询入库列表")
@MicroApiAnnotation(type = "read", version = "v1.0.65")
public class Stock_QueryInList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        if (StringUtils.isBlank(req.getToken())) {
            throw new MicroApiExecuteException(ErrorCodeEnum.missing_required_parameters);
        }
        DepartmentMember departmentMember = Commons.queryDepartmentMemberByToken(req.getToken());
        if (departmentMember == null) {
            throw new MicroApiExecuteException(ErrorCodeEnum.invalid_token);
        }
        Department department = Commons.queryDepartmentById(departmentMember.getDepartmentId());
        if (!Commons.hasPermission(department, PermissionEnum.stockQuery)) {
            throw new MicroApiExecuteException(ErrorCodeEnum.permission_denied);
        }
        PagerRequest pagerRequest = new PagerRequest(req.getPageIndex(), req.getPageSize());
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(NewStock.class).where(finalCondition).pager(pagerRequest).sorts(Sort.desc("dtCreate")).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, NewStock.class));
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(NewStock.class).where(finalCondition).build());
            resp.setPager(new PagerResponse(pagerRequest, IgniteUtils.getCount(selectCountRs)));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        return Where.and(LikeCondition.build("goodsName", req.getSearchKeyword())).toString();
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

        @Comment(value = "搜索 - 关键字")
        @Required(value = false)
        private String searchKeyword;

        public String getSearchKeyword() {
            return searchKeyword;
        }

        public void setSearchKeyword(String searchKeyword) {
            this.searchKeyword = searchKeyword;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "入库列表")
        @Required(value = true)
        private java.util.List<NewStock> data;

        public java.util.List<NewStock> getData() {
            return data;
        }

        public void setData(java.util.List<NewStock> data) {
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
