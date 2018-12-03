package com.news.service.impl;

import com.news.mapper.UserInfoMapper;
import com.news.po.NewsResult;
import com.news.pojo.UserInfo;
import com.news.pojo.UserInfoExample;
import com.news.service.UserService;
import com.news.utils.StateListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author One_llx
 * @Date 2018/12/3 0003 下午 3:09
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public NewsResult findUserList() {
        UserInfoExample userInfoExample=new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserStateIn(StateListUtils.getStateList());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        return NewsResult.ok(userInfos);
    }

    @Override
    public NewsResult saveUser(UserInfo userInfo) {
        userInfo.setUserState("1");
        userInfo.setUserTime(new Date());
        userInfoMapper.insertSelective(userInfo);
        return NewsResult.ok();
    }

    @Override
    public NewsResult updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return NewsResult.ok();
    }
}
