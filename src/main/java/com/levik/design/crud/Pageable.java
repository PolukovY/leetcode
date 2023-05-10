package com.levik.design.crud;

public class Pageable {
    private final int pageSize;
    private final int pageNum;

    private long start;

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

    @Override
    public String toString() {
        return "Pageable{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", start=" + start +
                '}';
    }
}
