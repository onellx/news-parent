package com.news.pojo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(catalogId, catalog.catalogId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catalogId, catalogName, catalogState);
    }
}