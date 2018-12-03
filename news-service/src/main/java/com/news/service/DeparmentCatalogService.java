package com.news.service;

import com.news.po.NewsResult;

import java.util.List;

/**
 * @ClassName DeparmentCatalogService
 * @Author One_llx
 * @Date 2018/11/28 0028 下午 3:39
 * @Version 1.0
 */
public interface DeparmentCatalogService {

    NewsResult saveDeparmentCatalog(Integer cid,Integer did);

    NewsResult updateDepartmentCatalog(Integer did, List<Integer> cids);

    NewsResult saveDepartmentCatalog(Integer did, List<Integer> cids);

    NewsResult deleteDepartmentCatalogByDid(Integer did);

    NewsResult deleteDepartmentCatalogByCid(Integer cid);





}
