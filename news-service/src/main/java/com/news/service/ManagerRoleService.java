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

    NewsResult saveRole(Integer managerId, List<Integer> roleIds);

    NewsResult deleteRoleByManagerId(Integer managerId);

}
