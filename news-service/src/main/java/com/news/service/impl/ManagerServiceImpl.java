package com.news.service.impl;

import com.news.mapper.DepartmentInfoMapper;
import com.news.po.ManagerPo;
import com.news.pojo.*;
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

    public NewsResult selectBynameNum(String managerNum) {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerNumberEqualTo(managerNum);
        List<Manager> userList = managerMapper.selectByExample(managerExample);
        return NewsResult.ok(userList);
    }


    public NewsResult insertManager(Manager manager) {
        //判断用户名是否重复
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andManagerNumberEqualTo(manager.getManagerNumber());
        criteria.andManagerStateEqualTo("1");
        List<Manager> list = managerMapper.selectByExample(example);
        if(list != null && list.size() != 0)   //如果不为空 ，该用户名已被注册
        {
            return NewsResult.build(400, "此工号已被注册");
        }
        manager.setManagerState("1");
        String md5Pass = Encrypt.md5(manager.getManagerPasswd(), manager.getManagerName());
        System.out.println(md5Pass);
        manager.setManagerPasswd(md5Pass);
        //添加一个用户
        managerMapper.insertSelective(manager);
        return NewsResult.ok();
    }//b33bad61b118c196d3e6e43e9417ab52

    public NewsResult managerList() {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        List<String> ids=new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        criteria.andManagerStateIn(ids);
        List<Manager> managers = managerMapper.selectByExample(managerExample);
        List<Integer> mids=new ArrayList<Integer>();
        List<Integer> dids=new ArrayList<Integer>();
        for (Manager m:managers) {
            mids.add(m.getManagerId());
            dids.add(m.getDepartmentId());
        }
        ManagerRoleExample managerRoleExample=new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria1 = managerRoleExample.createCriteria();
        criteria1.andManagerIdIn(mids);
        List<ManagerRole> managerRoles = managerRoleMapper.selectByExample(managerRoleExample);
        List<Integer> rids=new ArrayList<Integer>();
        for (ManagerRole mr:managerRoles) {
            rids.add(mr.getRoleId());
        }

        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria3 = roleExample.createCriteria();
        criteria3.andRoleIdIn(rids);
        List<Role> roles = roleMapper.selectByExample(roleExample);


        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria2 = departmentInfoExample.createCriteria();
        criteria2.andDepartmentIdIn(dids);
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);

        List<ManagerPo> managerPos=new ArrayList<ManagerPo>();
        for(int i=0;i<managers.size();i++){
            ManagerPo managerPo=new ManagerPo();
            managerPo.setManager(managers.get(i));
            managerPo.setRole(roles.get(i));
            managerPo.setDepartmentInfo(departmentInfos.get(i));
            managerPos.add(managerPo);
        }

        return NewsResult.ok(managerPos);
    }


}
