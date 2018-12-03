package com.news.service.impl;

import com.news.mapper.ManagerRoleMapper;
import com.news.po.NewsResult;
import com.news.pojo.ManagerRole;
import com.news.pojo.ManagerRoleExample;
import com.news.service.ManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ManagerRoleServiceImpl
 * @Author One_llx
 * @Date 2018/11/26 0026 下午 3:27
 * @Version 1.0
 */
@Service
public class ManagerRoleServiceImpl implements ManagerRoleService {

    @Autowired
    private ManagerRoleMapper managerRoleMapper;

    public NewsResult saveRole(Integer managerId, List<Integer> roleIds) {
        for (Integer roleId:roleIds) {
            ManagerRole managerRole=new ManagerRole();
            managerRole.setManagerId(managerId);
            managerRole.setRoleId(roleId);
            int i=managerRoleMapper.insertSelective(managerRole);
        }
        return NewsResult.ok();
    }

    @Override
    public NewsResult deleteRoleByManagerId(Integer managerId) {
        ManagerRoleExample managerRoleExample=new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria = managerRoleExample.createCriteria();
        criteria.andManagerIdEqualTo(managerId);
        managerRoleMapper.deleteByExample(managerRoleExample);
        return NewsResult.ok();
    }
}
