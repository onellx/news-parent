package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Catalog;

import java.util.List;

/**
 * @ClassName CatalogService
 * @Author One_llx
 * @Date 2018/11/27 0027 下午 11:18
 * @Version 1.0
 */
public interface CatalogService {
    /**
     *查找所有的栏目
     * @return
     */
    NewsResult findCatalogList();

    /**
     *更新栏目信息
     * @param catalog 要更新的栏目信息对象
     * @return
     */
    NewsResult updateCatalog(Catalog catalog);

    /**
     *通过ID查找栏目
     * @param id 要查找的栏目id
     * @return
     */
    NewsResult findCatalogById(Integer id);

    /**
     *添加栏目
     * @param catalog 要添加的栏目信息对象
     * @return
     */
    NewsResult saveCatalog(Catalog catalog);

    /**
     *通过栏目的名称查找栏目信息
     * @param cataologName 要查找的栏目的栏目名称
     * @return
     */
    NewsResult findCatalogByName(String cataologName);

    /**
     *通过多个栏目ID查找多个栏目信息
     * @param cids 栏目ids
     * @return
     */
    NewsResult findCatalogListByCids(List<Integer> cids);

    NewsResult findCatalogListByDid(Integer did);

}
