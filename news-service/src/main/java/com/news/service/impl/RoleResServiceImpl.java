package com.news.service.impl;

import com.news.mapper.RoleMapper;
import com.news.pojo.*;
import com.news.service.ManagerRoleService;
import com.news.service.ModuleService;
import com.news.service.RoleResService;
import com.news.mapper.ManagerRoleMapper;
import com.news.mapper.ModuleMapper;
import com.news.mapper.RoleModuleMapper;
import com.news.po.*;
import com.news.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RoleResServiceImpl
 * @Author One_llx
 * @Date 2018/11/19 0019 下午 3:41
 * @Version 1.0
 */
@Service
public class RoleResServiceImpl implements RoleResService {
    @Autowired
    private RoleModuleMapper roleModuleMapper;//资源
    @Autowired
    private ManagerRoleService managerRoleService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleService roleService;

    /**
     * 根据用户ID找到对应的权限资源
     * @param managerId
     * @return
     */

    public NewsResult getResByManagerId(int managerId) {
        List<Integer> roleIds=getRoleList(managerId);
        //通过角色id获取模块id
        RoleModuleExample roleModuleExample=new RoleModuleExample();
        RoleModuleExample.Criteria criteria1 = roleModuleExample.createCriteria();
        criteria1.andRoleIdIn(roleIds);
        List<RoleModule> roleModules = roleModuleMapper.selectByExample(roleModuleExample);
        List<Integer> moudleIds=new ArrayList<Integer>();
        for (RoleModule r:roleModules) {
            moudleIds.add(r.getModuleId());
        }
        //更据模块id查找模块
        List<Module> resList = (List<Module>) moduleService.findModuleByMids(moudleIds).getData();
        return NewsResult.ok(resList);
    }

    public NewsResult getRoleByManagerId(int managerId) {
        List<Integer> roleIds=getRoleList(managerId);
        //通过角色id查找角色
        List<Role> roles = (List<Role>) roleService.findRoleListByRids(roleIds).getData();
        return NewsResult.ok(roles);
    }

    /**
     * 根据管理员id查找角色id
     * @param managerId
     * @return
     */
    protected List<Integer> getRoleList(int managerId){
        //先通过用户id获取用户的角色
        List<ManagerRole> managerRoles = (List<ManagerRole>) managerRoleService.findManagerRoleByMid(managerId).getData();
        List<Integer> roleIds=new ArrayList<Integer>();
        for (ManagerRole m:managerRoles) {
            roleIds.add(m.getRoleId());
        }
        return roleIds;
    }
}
