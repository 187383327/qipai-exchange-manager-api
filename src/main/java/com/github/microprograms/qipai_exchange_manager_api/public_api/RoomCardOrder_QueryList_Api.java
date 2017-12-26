package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;
import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.ComplexCondition;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.LikeCondition;
import com.github.microprograms.ignite_utils.sql.dml.PagerRequest;
import com.github.microprograms.ignite_utils.sql.dml.PagerResponse;
import com.github.microprograms.ignite_utils.sql.dml.SelectCountSql;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "房卡订单 - 查询列表")
@MicroApiAnnotation(type = "read", version = "v1.0.56")
public class RoomCardOrder_QueryList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        PagerRequest pagerRequest = new PagerRequest(req.getPageIndex(), req.getPageSize());
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(MixOrder.class).where(finalCondition).pager(pagerRequest).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, MixOrder.class));
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(MixOrder.class).where(finalCondition).build());
            resp.setPager(new PagerResponse(pagerRequest, IgniteUtils.getCount(selectCountRs)));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        ComplexCondition dtCreate = Where.and(Condition.build("dtCreate>", req.getSearchBeginTimestamp()), Condition.build("dtCreate<", req.getSearchEndTimestamp()));
        LikeCondition keyword = LikeCondition.build("id", req.getSearchKeyword());
        ComplexCondition transportReceiver = Where.or(LikeCondition.build("transportReceiver", req.getSearchTransportReceiver()), LikeCondition.build("transportPhone", req.getSearchTransportReceiver()));
        Condition status = (req.getSearchStatus() == null || req.getSearchStatus() == 0) ? null : Condition.build("status=", req.getSearchStatus());
        Condition orderType = Condition.build("orderType=", 2);
        return Where.and(dtCreate, keyword, transportReceiver, status, orderType).toString();
    }

    public static class Req extends Request {

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

        @Comment(value = "搜索 - 关键字(订单号/商品名/商品编号)")
        @Required(value = false)
        private String searchKeyword;

        public String getSearchKeyword() {
            return searchKeyword;
        }

        public void setSearchKeyword(String searchKeyword) {
            this.searchKeyword = searchKeyword;
        }

        @Comment(value = "搜索 - 收货人(收货人/手机号)")
        @Required(value = false)
        private String searchTransportReceiver;

        public String getSearchTransportReceiver() {
            return searchTransportReceiver;
        }

        public void setSearchTransportReceiver(String searchTransportReceiver) {
            this.searchTransportReceiver = searchTransportReceiver;
        }

        @Comment(value = "搜索 - 开始时间戳")
        @Required(value = false)
        private Long searchBeginTimestamp;

        public Long getSearchBeginTimestamp() {
            return searchBeginTimestamp;
        }

        public void setSearchBeginTimestamp(Long searchBeginTimestamp) {
            this.searchBeginTimestamp = searchBeginTimestamp;
        }

        @Comment(value = "搜索 - 结束时间戳")
        @Required(value = false)
        private Long searchEndTimestamp;

        public Long getSearchEndTimestamp() {
            return searchEndTimestamp;
        }

        public void setSearchEndTimestamp(Long searchEndTimestamp) {
            this.searchEndTimestamp = searchEndTimestamp;
        }

        @Comment(value = "搜索 - 订单状态")
        @Required(value = false)
        private Integer searchStatus;

        public Integer getSearchStatus() {
            return searchStatus;
        }

        public void setSearchStatus(Integer searchStatus) {
            this.searchStatus = searchStatus;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "房卡订单列表")
        @Required(value = true)
        private java.util.List<MixOrder> data;

        public java.util.List<MixOrder> getData() {
            return data;
        }

        public void setData(java.util.List<MixOrder> data) {
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
