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
    /**
     * 给部门添加栏目权限
     * @param cid 栏目id
     * @param did 部门id
     * @return
     */
    NewsResult saveDeparmentCatalog(Integer cid,Integer did);

    /**
     *更新部门的栏目权限
     * @param did 部门id
     * @param cids 栏目id
     * @return
     */
    NewsResult updateDepartmentCatalog(Integer did, List<Integer> cids);

    /**
     *添加部门权限
     * @param did 部门id
     * @param cids 栏目id
     * @return
     */
    NewsResult saveDepartmentCatalog(Integer did, List<Integer> cids);

    /**
     *通过部门ID删除该部门的所有权限
     * @param did 部门id
     * @return
     */
    NewsResult deleteDepartmentCatalogByDid(Integer did);

    /**
     *通过栏目ID删除所有有它权限的部门
     * @param cid 栏目id
     * @return
     */
    NewsResult deleteDepartmentCatalogByCid(Integer cid);

    /**
     *通过部门id查找这个部门所有的部门与栏目直接的关系信息
     * @param did 部门id
     * @return
     */
    NewsResult findDepartmentCatalofListByDid(Integer did);





}
