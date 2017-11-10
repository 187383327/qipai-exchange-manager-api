package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.sql.Connection;
import java.sql.ResultSet;

import com.github.microprograms.ignite_utils.IgniteUtils;
import com.github.microprograms.ignite_utils.sql.dml.ComplexCondition;
import com.github.microprograms.ignite_utils.sql.dml.Condition;
import com.github.microprograms.ignite_utils.sql.dml.LikeCondition;
import com.github.microprograms.ignite_utils.sql.dml.SelectSql;
import com.github.microprograms.ignite_utils.sql.dml.Where;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;
import com.github.microprograms.qipai_exchange_manager_api.utils.Consts;

@Comment(value = "商品 - 查询列表")
@MicroApiAnnotation(type = "read", version = "v1.0.6")
public class Goods_QueryList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            SelectSql selectSql = new SelectSql();
            selectSql.tableName(Goods.class.getSimpleName());
            selectSql.where(buildFinalCondition(req));
            selectSql.pager(IgniteUtils.buildPager(req.getPageIndex(), req.getPageSize()));
            ResultSet rs = conn.createStatement().executeQuery(selectSql.build());
            resp.setData(IgniteUtils.getJavaObjectList(rs, Goods.class));
        }
        return resp;
    }

    private static String buildFinalCondition(Req req) {
        ComplexCondition dtCreate = Where.and(Condition.build("dtCreate>", req.getSearchBeginTimestamp()), Condition.build("dtCreate<", req.getSearchEndTimestamp()));
        ComplexCondition stock = Where.and(Condition.build("stock>", req.getSearchMinStock()), Condition.build("stock<", req.getSearchMaxStock()));
        LikeCondition keyword = LikeCondition.build("name", req.getSearchKeyword());
        return Where.and(dtCreate, stock, keyword).toString();
    }

    public static class Req extends Request {

        @Comment(value = "页码(从0开始)") @Required(value = true) private Integer pageIndex;

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        @Comment(value = "页大小") @Required(value = true) private Integer pageSize;

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        @Comment(value = "搜索 - 关键字") @Required(value = false) private String searchKeyword;

        public String getSearchKeyword() {
            return searchKeyword;
        }

        public void setSearchKeyword(String searchKeyword) {
            this.searchKeyword = searchKeyword;
        }

        @Comment(value = "搜索 - 开始时间戳") @Required(value = false) private Long searchBeginTimestamp;

        public Long getSearchBeginTimestamp() {
            return searchBeginTimestamp;
        }

        public void setSearchBeginTimestamp(Long searchBeginTimestamp) {
            this.searchBeginTimestamp = searchBeginTimestamp;
        }

        @Comment(value = "搜索 - 结束时间戳") @Required(value = false) private Long searchEndTimestamp;

        public Long getSearchEndTimestamp() {
            return searchEndTimestamp;
        }

        public void setSearchEndTimestamp(Long searchEndTimestamp) {
            this.searchEndTimestamp = searchEndTimestamp;
        }

        @Comment(value = "搜索 - 最小库存") @Required(value = false) private Integer searchMinStock;

        public Integer getSearchMinStock() {
            return searchMinStock;
        }

        public void setSearchMinStock(Integer searchMinStock) {
            this.searchMinStock = searchMinStock;
        }

        @Comment(value = "搜索 - 最大库存") @Required(value = false) private Integer searchMaxStock;

        public Integer getSearchMaxStock() {
            return searchMaxStock;
        }

        public void setSearchMaxStock(Integer searchMaxStock) {
            this.searchMaxStock = searchMaxStock;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "商品列表") @Required(value = true) private java.util.List<Goods> data;

        public java.util.List<Goods> getData() {
            return data;
        }

        public void setData(java.util.List<Goods> data) {
            this.data = data;
        }

        @Comment(value = "分页") @Required(value = true) private Pager pager;

        public Pager getPager() {
            return pager;
        }

        public void setPager(Pager pager) {
            this.pager = pager;
        }
    }
}
