package com.github.microprograms.qipai_exchange_manager_api.utils;

public class Pager {
    private final int pageIndex;
    private final int pageSize;

    public Pager(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return String.format("LIMIT %s OFFSET %s", pageSize, pageIndex * pageSize);
    }
}
