package com.levik.design.chat.custome.chat.model;

public class Pageable {

    private final int pageSize;
    private final int pageNum;

    private long start;

    public Pageable() {
        this.pageNum = 0;
        this.pageSize = 10;
    }

    public Pageable(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Pageable(int pageSize, int pageNum, long start) {
        this(pageSize, pageNum);
        this.start = start;
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
