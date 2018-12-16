package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Manager;

import java.util.List;

/**
 * @ClassName ManagerService
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 3:59
 * @Version 1.0
 */
public interface ManagerService {



    /**
     * 添加管理员
     * @param manager 管理员信息
     * @param roldIds 权限id
     * @return
     */
    NewsResult insertManager(Manager manager,List<Integer> roldIds);

    /**
     *查找所有的ManagerPo
     * @return
     */
    NewsResult findManagerPoList();

    /**
     *获取所有管理员信息
     * @return
     */
    NewsResult findManagerList();

    /**
     *更新管理员信息
     * @param manager 要更新的管理信息
     * @return
     */
    NewsResult updateManager(Manager manager);

    /**
     *根据id查找管理员
     * @param id 管理员id
     * @return
     */
    NewsResult findManagerById(Integer id);


    /**
     *修改密码
     * @param manager 管理信息
     * @return
     */
    NewsResult updateManagerPasswd(Manager manager);

    /**
     *根据工号查找管理员
     * @param number 管理员工号
     * @return
     */
    NewsResult findManagerByNumber(String number);

    /**
     * 查找出超级管理员列表
     * @return
     */
    NewsResult findSuperManagerList();

    /**
     * 根据管理员名称查找管理员
     * @param managerName 管理员名称
     * @return
     */
    NewsResult finManagerByName(String managerName);

    /**
     *  更新管理员权限
     * @param manager 管理员信息
     * @param roldIds 权限
     * @return
     */
    NewsResult updateManagerRole(Manager manager,List<Integer> roldIds);

    /**
     * 根据部门id查找该部门的所有管理员
     * @param did
     * @return
     */
    NewsResult findManagerPoListByDid(Integer did);


}
