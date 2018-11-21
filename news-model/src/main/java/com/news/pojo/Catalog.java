package com.news.pojo;

public class Catalog {
    private Integer catalogId;

    private String catalogName;

    private String catalogState;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(String catalogState) {
        this.catalogState = catalogState == null ? null : catalogState.trim();
    }
}