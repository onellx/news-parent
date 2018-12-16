package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.UserInfo;

/**
 * @ClassName UserService
 * @Author One_llx
 * @Date 2018/12/3 0003 下午 3:08
 * @Version 1.0
 */
public interface UserService {
    /**
     *查找用户列表
     * @return
     */
    NewsResult findUserList();

    /**
     *添加用户信息
     * @param userInfo
     * @return
     */
    NewsResult saveUser(UserInfo userInfo);

    /**
     *更新用户信息
     * @param userInfo 要更新的用户信息
     * @return
     */
    NewsResult updateUser(UserInfo userInfo);

    /**
     *通过邮箱查找用户
     * @param email 邮箱信息
     * @return
     */
    NewsResult findUserByEmail(String email);



}
