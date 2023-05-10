package com.levik.design.crud;

import java.util.List;

public class Page<T> {

    private final List<T> items;
    private final int totalSize;
    private final int pageSize;
    private final int pageNum;
    private long start;

    public Page(List<T> items, int totalSize, int pageSize, int pageNum, long start) {
        this.items = items;
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.start = start;
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public long getStart() {
        return start;
    }
}
