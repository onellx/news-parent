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

    NewsResult findUserList();

    NewsResult saveUser(UserInfo userInfo);

    NewsResult updateUser(UserInfo userInfo);

    NewsResult findUserByEmail(String email);



}
