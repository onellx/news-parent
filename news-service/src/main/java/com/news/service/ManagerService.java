package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Manager;

/**
 * @ClassName ManagerService
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 3:59
 * @Version 1.0
 */
public interface ManagerService {
    //根据用户名字来查找用户，返回一个userlist
    NewsResult selectBynameNum(String managerNum);

    //添加用户
    NewsResult insertManager(Manager manager);

    NewsResult managerList();
}
