package com.news.service;

import com.news.po.NewsResult;

import java.util.List;

/**
 * @ClassName ManagerRoleService
 * @Author One_llx
 * @Date 2018/11/26 0026 下午 3:27
 * @Version 1.0
 */
public interface ManagerRoleService {

    /**
     * 根据管理员id给这个管理员添加更多的权限
     * @param managerId 管理员ID
     * @param roleIds 权限ID
     * @return
     */
    NewsResult saveRole(Integer managerId, List<Integer> roleIds);

    /**
     *根据管理员ID去除该管理员的所有权限
     * @param managerId 管理员ID
     * @return
     */
    NewsResult deleteRoleByManagerId(Integer managerId);

    /**
     *根据管理ID查找该管理员的权限信息
     * @param mid 管理员id
     * @return
     */
    NewsResult findManagerRoleByMid(Integer mid);

}
