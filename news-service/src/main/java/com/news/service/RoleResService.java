package com.news.service;

import com.news.po.NewsResult;

/**
 * @ClassName RoleResService
 * @Author One_llx
 * @Date 2018/11/19 0019 上午 11:20
 * @Version 1.0
 */
public interface RoleResService {
    //查询角色资源
    //List<EasyUITreeNode> getRoleRes(int roleid,String roletype);

    /**
     * 更具管理员的id查找该管理的资源
     * @param managerId
     * @return
     */
    NewsResult getResByManagerId(int managerId);

    /**
     * 根据管理员的id获取该管理员的角色
     * @param managerId
     * @return
     */
    public NewsResult getRoleByManagerId(int managerId);
}
