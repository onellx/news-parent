package com.news.service.impl;

import com.news.mapper.RoleMapper;
import com.news.pojo.*;
import com.news.service.RoleResService;
import com.news.mapper.ManagerRoleMapper;
import com.news.mapper.ModuleMapper;
import com.news.mapper.RoleModuleMapper;
import com.news.po.*;
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
    private RoleModuleMapper roleModuleMapper;
    @Autowired
    private ManagerRoleMapper managerRoleMapper;
   @Autowired
   private ModuleMapper moduleMapper;
   @Autowired
   private RoleMapper roleMapper;

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
        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria2 = moduleExample.createCriteria();
        criteria2.andModuleIdIn(moudleIds);
        List<Module> resList = moduleMapper.selectByExample(moduleExample);
        return NewsResult.ok(resList);
    }

    public NewsResult getRoleByManagerId(int managerId) {
        List<Integer> roleIds=getRoleList(managerId);

        //通过角色id查找角色
        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria1 = roleExample.createCriteria();
        criteria1.andRoleIdIn(roleIds);
        List<Role> roles = roleMapper.selectByExample(roleExample);

        return NewsResult.ok(roles);
    }

    /**
     * 根据管理员id查找角色id
     * @param managerId
     * @return
     */
    protected List<Integer> getRoleList(int managerId){
        //先通过用户id获取用户的角色
        ManagerRoleExample managerRoleExample=new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria = managerRoleExample.createCriteria();
        criteria.andManagerIdEqualTo(managerId);
        List<ManagerRole> managerRoles = managerRoleMapper.selectByExample(managerRoleExample);
        List<Integer> roleIds=new ArrayList<Integer>();
        for (ManagerRole m:managerRoles) {
            roleIds.add(m.getRoleId());
        }

        return roleIds;
    }
}
