package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.PagerRequest;
import com.github.microprograms.ignite_utils.sql.dml.PagerResponse;
import com.github.microprograms.ignite_utils.sql.dml.SelectCountSql;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "图文 - 查询列表")
@MicroApiAnnotation(type = "read", version = "v1.0.58")
public class ImageText_QueryList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        PagerRequest pagerRequest = new PagerRequest(req.getPageIndex(), req.getPageSize());
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(ImageText.class).pager(pagerRequest).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, ImageText.class));
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(ImageText.class).build());
            resp.setPager(new PagerResponse(pagerRequest, IgniteUtils.getCount(selectCountRs)));
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
    }

    public static class Resp extends Response {

        @Comment(value = "图文列表")
        @Required(value = true)
        private java.util.List<ImageText> data;

        public java.util.List<ImageText> getData() {
            return data;
        }

        public void setData(java.util.List<ImageText> data) {
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
