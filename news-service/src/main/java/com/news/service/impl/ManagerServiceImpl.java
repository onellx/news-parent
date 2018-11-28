package com.news.service.impl;

import com.news.mapper.DepartmentInfoMapper;
import com.news.po.ManagerPo;
import com.news.pojo.*;
import com.news.service.ManagerRoleService;
import com.news.service.ManagerService;
import com.news.mapper.ManagerMapper;
import com.news.mapper.ManagerRoleMapper;
import com.news.mapper.RoleMapper;
import com.news.po.NewsResult;
import com.news.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName UserServiceImpl
 * @Author One_llx
 * @Date 2018/11/19 0019 下午 3:20
 * @Version 1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ManagerRoleMapper managerRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;
    @Autowired
    private ManagerRoleService managerRoleService;

    public NewsResult selectBynameNum(String managerNum) {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerNumberEqualTo(managerNum);
        List<Manager> userList = managerMapper.selectByExample(managerExample);
        return NewsResult.ok(userList);
    }


    public NewsResult insertManager(Manager manager,List<Integer> roldIds) {

        manager.setManagerState("1");
        String md5Pass = Encrypt.md5(manager.getManagerPasswd(), manager.getManagerNumber());
        System.out.println(md5Pass);
        manager.setManagerPasswd(md5Pass);
        //添加一个用户
        managerMapper.insertSelective(manager);
        Integer managerId=manager.getManagerId();
        managerRoleService.saveRole(managerId,roldIds);

        return NewsResult.ok();
    }

    public NewsResult managerList() {
        List<ManagerPo> managerPos=new ArrayList<ManagerPo>();
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        List<String> ids=new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        criteria.andManagerStateIn(ids);
        List<Manager> managers = managerMapper.selectByExample(managerExample);

        if (managers.isEmpty()) {
            return NewsResult.build(400,"没有管理员",managerPos);
        }
        List<Integer> dids=new ArrayList<Integer>();
        for (Manager m:managers) {
            dids.add(m.getDepartmentId());
        }
        //获取部门列表
        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria2 = departmentInfoExample.createCriteria();
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);
        Map<Integer, DepartmentInfo> departmentInfoMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getDepartmentId, a -> a,(k1, k2)->k1));
        //获取权限列表

        for(int i=0;i<managers.size();i++){
            ManagerPo managerPo=new ManagerPo();
            managerPo.setManager(managers.get(i));
            managerPo.setDepartmentInfo(departmentInfoMap.get(managers.get(i).getDepartmentId()));
            //可优化处
            ManagerRoleExample managerRoleExample=new ManagerRoleExample();
            ManagerRoleExample.Criteria criteria1 = managerRoleExample.createCriteria();
            criteria1.andManagerIdEqualTo(managers.get(i).getManagerId());
            List<ManagerRole> managerRoles = managerRoleMapper.selectByExample(managerRoleExample);
            List<Integer> rids=new ArrayList<Integer>();
            for (ManagerRole mr:managerRoles) {
                rids.add(mr.getRoleId());
            }
            RoleExample roleExample=new RoleExample();
            RoleExample.Criteria criteria3 = roleExample.createCriteria();
            criteria3.andRoleIdIn(rids);
            List<Role> roles = roleMapper.selectByExample(roleExample);
            managerPo.setRoles(roles);
            managerPos.add(managerPo);
        }

        return NewsResult.ok(managerPos);
    }

    public NewsResult updateManager(Manager manager) {

        managerMapper.updateByPrimaryKeySelective(manager);
        return NewsResult.ok();
    }

    public NewsResult findManagerById(Integer id) {

        Manager manager=managerMapper.selectByPrimaryKey(id);
        DepartmentInfo departmentInfo=departmentInfoMapper.selectByPrimaryKey(manager.getDepartmentId());

        ManagerRoleExample managerRoleExample=new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria = managerRoleExample.createCriteria();
        criteria.andManagerIdEqualTo(id);
        List<ManagerRole> managerRoles = managerRoleMapper.selectByExample(managerRoleExample);
        List<Integer> rids=new ArrayList<Integer>();
        for (ManagerRole m:managerRoles) {
            rids.add(m.getRoleId());
        }

        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria1 = roleExample.createCriteria();
        criteria1.andRoleIdIn(rids);
        List<Role> roles = roleMapper.selectByExample(roleExample);

        ManagerPo managerPo=new ManagerPo();
        managerPo.setManager(manager);
        managerPo.setDepartmentInfo(departmentInfo);
        managerPo.setRoles(roles);

        return NewsResult.ok(managerPo);
    }

    /**
     * 更新一个用户信息
     * @param manager
     * @return
     */
    public NewsResult updateManagerPasswd(Manager manager) {
        String md5Pass = Encrypt.md5(manager.getManagerPasswd(), manager.getManagerNumber());
        manager.setManagerPasswd(md5Pass);
        managerMapper.updateByPrimaryKeySelective(manager);
        return NewsResult.ok();
    }

    public NewsResult findManagerByNumber(String number) {
        //判断用户名是否重复
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andManagerNumberEqualTo(number);
        criteria.andManagerStateEqualTo("1");
        List<Manager> list = managerMapper.selectByExample(example);
        if(list != null && list.size() != 0)   //如果不为空 ，该用户名已被注册
        {
            return NewsResult.build(400, "此工号已被注册");
        }

        return NewsResult.ok();
    }


}
