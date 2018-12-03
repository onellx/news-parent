package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Catalog;

/**
 * @ClassName CatalogService
 * @Author One_llx
 * @Date 2018/11/27 0027 下午 11:18
 * @Version 1.0
 */
public interface CatalogService {

    NewsResult findCatalogList();

    NewsResult updateCatalog(Catalog catalog);

    NewsResult findCatalogById(Integer id);

    NewsResult saveCatalog(Catalog catalog);

    NewsResult findCatalogByName(String cataologName);
}
