package com.news.service.impl;

import com.news.mapper.RoleMapper;
import com.news.po.NewsResult;
import com.news.pojo.Role;
import com.news.pojo.RoleExample;
import com.news.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Author One_llx
 * @Date 2018/11/22 0022 下午 5:18
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public NewsResult findRoleList() {

        List<Role> roles = roleMapper.selectByExample(new RoleExample());
        return NewsResult.ok(roles);
    }

}
