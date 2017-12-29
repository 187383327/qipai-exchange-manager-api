package com.github.microprograms.qipai_exchange_manager_api.public_api;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

@Comment(value = "商品/优选商品 - 查询列表")
@MicroApiAnnotation(type = "read", version = "v1.0.63")
public class Goods_QueryList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        PagerRequest pagerRequest = new PagerRequest(req.getPageIndex(), req.getPageSize());
        try (Connection conn = IgniteUtils.getConnection(Consts.jdbc_url)) {
            List<String> fieldNames = new ArrayList<>();
            fieldNames.add("id");
            fieldNames.add("categoryId");
            fieldNames.add("categoryName");
            fieldNames.add("name");
            fieldNames.add("price");
            fieldNames.add("vipPrice");
            fieldNames.add("goldVipPrice");
            fieldNames.add("reorder");
            fieldNames.add("stock");
            fieldNames.add("exchangeAmount");
            fieldNames.add("dtCreate");
            fieldNames.add("pictures");
            // fieldNames.add("detail");
            fieldNames.add("isDelete");
            fieldNames.add("type");
            fieldNames.add("dtLastModify");
            String finalCondition = buildFinalCondition(req);
            ResultSet selectRs = conn.createStatement().executeQuery(new SelectSql(Goods.class).fieldNames(fieldNames).where(finalCondition).pager(pagerRequest).build());
            resp.setData(IgniteUtils.getJavaObjectList(selectRs, Goods.class));
            ResultSet selectCountRs = conn.createStatement().executeQuery(new SelectCountSql(Goods.class).where(finalCondition).build());
            resp.setPager(new PagerResponse(pagerRequest, IgniteUtils.getCount(selectCountRs)));
        }
        return resp;
    }

    public static void main(String[] args) {
        for (Field x : Goods.class.getDeclaredFields()) {
            System.out.println(String.format("fieldNames.add(\"%s\");", x.getName()));
        }
    }

    private static String buildFinalCondition(Req req) {
        ComplexCondition dtCreate = Where.and(Condition.build("dtCreate>", req.getSearchBeginTimestamp()), Condition.build("dtCreate<", req.getSearchEndTimestamp()));
        ComplexCondition stock = Where.and(Condition.build("stock>", req.getSearchMinStock()), Condition.build("stock<", req.getSearchMaxStock()));
        LikeCondition keyword = LikeCondition.build("name", req.getSearchKeyword());
        Condition isDelete = Condition.build("isDelete=", "0");
        Condition type = Condition.build("type=", req.getType() == null ? 1 : req.getType());
        return Where.and(dtCreate, stock, keyword, isDelete, type).toString();
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

        @Comment(value = "商品类型(1普通商品,2优选商品)")
        @Required(value = true)
        private Integer type;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
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

        @Comment(value = "搜索 - 最小库存")
        @Required(value = false)
        private Integer searchMinStock;

        public Integer getSearchMinStock() {
            return searchMinStock;
        }

        public void setSearchMinStock(Integer searchMinStock) {
            this.searchMinStock = searchMinStock;
        }

        @Comment(value = "搜索 - 最大库存")
        @Required(value = false)
        private Integer searchMaxStock;

        public Integer getSearchMaxStock() {
            return searchMaxStock;
        }

        public void setSearchMaxStock(Integer searchMaxStock) {
            this.searchMaxStock = searchMaxStock;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "商品列表")
        @Required(value = true)
        private java.util.List<Goods> data;

        public java.util.List<Goods> getData() {
            return data;
        }

        public void setData(java.util.List<Goods> data) {
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
