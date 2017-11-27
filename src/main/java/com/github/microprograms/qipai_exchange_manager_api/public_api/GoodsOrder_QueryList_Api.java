package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Response;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@Comment(value = "商品订单 - 查询列表")
@MicroApiAnnotation(type = "read", version = "v1.0.24")
public class GoodsOrder_QueryList_Api {

    public static Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        return resp;
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

        @Comment(value = "商品订单列表")
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
