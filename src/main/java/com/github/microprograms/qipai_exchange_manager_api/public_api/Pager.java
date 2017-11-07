package com.github.microprograms.qipai_exchange_manager_api.public_api;

import com.github.microprograms.micro_entity_definition_runtime.annotation.MicroEntityAnnotation;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Comment;
import com.github.microprograms.micro_entity_definition_runtime.annotation.Required;

@MicroEntityAnnotation()
public class Pager {

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

    @Comment(value = "数据库总行数")
    @Required(value = true)
    private Integer totalRecords;

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Comment(value = "总页数")
    @Required(value = true)
    private Integer totalPages;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Comment(value = "是否为首页(0否1是)")
    @Required(value = true)
    private Integer isFirstPage;

    public Integer getIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(Integer isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    @Comment(value = "是否为尾页(0否1是)")
    @Required(value = true)
    private Integer isLastPage;

    public Integer getIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(Integer isLastPage) {
        this.isLastPage = isLastPage;
    }
}
