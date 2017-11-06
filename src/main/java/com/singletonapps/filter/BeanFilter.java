package com.singletonapps.filter;

import javax.ws.rs.QueryParam;

public class BeanFilter {

    @QueryParam("year")
    private int year;

    @QueryParam("offset")
    private int offset;

    @QueryParam("size")
    private int size;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
