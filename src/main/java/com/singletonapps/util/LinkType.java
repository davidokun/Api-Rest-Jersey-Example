package com.singletonapps.util;

public enum LinkType {

    SELF("self"),
    AUTHOR("author"),
    COMMENTS("comments");

    private String type;

    LinkType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
