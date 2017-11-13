package com.singletonapps.model;

public class Link {

    private String url;
    private String rel;

    public Link() {
    }

    public Link(String url, String rel) {
        this.url = url;
        this.rel = rel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (url != null ? !url.equals(link.url) : link.url != null) return false;
        return rel != null ? rel.equals(link.rel) : link.rel == null;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (rel != null ? rel.hashCode() : 0);
        return result;
    }
}
