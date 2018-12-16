package com.news.service.impl;

import com.news.mapper.DepartmentInfoMapper;
import com.news.po.ManagerPo;
import com.news.pojo.*;
import com.news.service.DepartmentService;
import com.news.service.ManagerRoleService;
import com.news.service.ManagerService;
import com.news.mapper.ManagerMapper;
import com.news.mapper.ManagerRoleMapper;
import com.news.mapper.RoleMapper;
import com.news.po.NewsResult;
import com.news.service.RoleService;
import com.news.utils.Encrypt;
import com.news.utils.StateListUtils;
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
    private RoleService roleService;
    @Autowired
    private ManagerRoleService managerRoleService;
    @Autowired
    private DepartmentService departmentService;



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

    public NewsResult findManagerPoList() {

        List<Manager> managers = (List<Manager>) this.findManagerList().getData();
        if (managers.isEmpty()) {
            return NewsResult.build(400,"没有管理员",null);
        }
        List<ManagerPo> managerPos= (List<ManagerPo>) this.getManagerPoList(managers).getData();
        return NewsResult.ok(managerPos);
    }

    @Override
    public NewsResult findManagerList() {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerStateIn(StateListUtils.getStateList());
        List<Manager> managers = managerMapper.selectByExample(managerExample);
        return NewsResult.ok(managers);
    }

    public NewsResult updateManager(Manager manager) {
        if(manager.getManagerState()!=null){
            if (manager.getManagerState().equals("3")){
                Manager manager1 = managerMapper.selectByPrimaryKey(manager.getManagerId());
                departmentService.updateDepartmentLikman(manager1.getManagerName());
            }
        }

        managerMapper.updateByPrimaryKeySelective(manager);
        return NewsResult.ok();
    }

    public NewsResult findManagerById(Integer id) {

        Manager manager=managerMapper.selectByPrimaryKey(id);
        DepartmentInfo departmentInfo= (DepartmentInfo) departmentService.findDepartmentById(manager.getDepartmentId()).getData();
        List<ManagerRole> managerRoles = (List<ManagerRole>) managerRoleService.findManagerRoleByMid(id).getData();
        List<Integer> rids=new ArrayList<Integer>();
        for (ManagerRole m:managerRoles) {
            rids.add(m.getRoleId());
        }
        List<Role> roles = (List<Role>) roleService.findRoleListByRids(rids).getData();
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
        criteria.andManagerStateIn(StateListUtils.getStateList());
        List<Manager> list = managerMapper.selectByExample(example);
        if(list != null && list.size() != 0)   //如果不为空 ，该用户名已被注册
        {
            return NewsResult.ok( list);
        }

        return NewsResult.build(400, "没有此工号",null);
    }

    @Override
    public NewsResult findSuperManagerList() {
        NewsResult newsResult = findManagerPoList();
        List<ManagerPo> managerPos = (List<ManagerPo>) newsResult.getData();
        List<Manager> managers=new ArrayList<Manager>();
        //可优化
        for (int i=0;i<managerPos.size();i++) {
            if (managerPos.get(i).getRoles().get(i).getRoleId()==1){
                managers.add(managerPos.get(i).getManager());
            }
        }
        return NewsResult.ok(managers);
    }

    @Override
    public NewsResult finManagerByName(String managerName) {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerNameEqualTo(managerName);
        criteria.andManagerStateIn(StateListUtils.getStateList());
        List<Manager> managers = managerMapper.selectByExample(managerExample);
        if (managers.isEmpty()){
            return NewsResult.build(400,"没有此管理员");
        }
        return NewsResult.ok(managers);
    }

    @Override
    public NewsResult updateManagerRole(Manager manager, List<Integer> roldIds) {
        List<Manager> managers= (List<Manager>) this.findManagerByNumber(manager.getManagerNumber()).getData();
        Manager m=managers.get(0);
        manager.setManagerId(m.getManagerId());
        this.updateManager(manager);
        managerRoleService.deleteRoleByManagerId(manager.getManagerId());
        managerRoleService.saveRole(manager.getManagerId(),roldIds);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findManagerPoListByDid(Integer did) {
        ManagerExample managerExample=new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerStateIn(StateListUtils.getStateList());
        criteria.andDepartmentIdEqualTo(did);
        List<Manager> managers = managerMapper.selectByExample(managerExample);
        if (managers.isEmpty()) {
            return NewsResult.build(400,"没有管理员",null);
        }
        List<ManagerPo> managerPos= (List<ManagerPo>) this.getManagerPoList(managers).getData();
        return NewsResult.ok(managerPos);
    }

    private NewsResult getManagerPoList(List<Manager> managers){
        List<ManagerPo> managerPos=new ArrayList<ManagerPo>();
        List<Integer> dids=new ArrayList<Integer>();
        for (Manager m:managers) {
            dids.add(m.getDepartmentId());
        }
        //获取部门列表
        List<DepartmentInfo> departmentInfos = (List<DepartmentInfo>) departmentService.findDepartmentList().getData();
        Map<Integer, DepartmentInfo> departmentInfoMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getDepartmentId, a -> a,(k1, k2)->k1));
        //获取权限列表
        for(int i=0;i<managers.size();i++){
            ManagerPo managerPo=new ManagerPo();
            managerPo.setManager(managers.get(i));
            managerPo.setDepartmentInfo(departmentInfoMap.get(managers.get(i).getDepartmentId()));
            //可优化处
            List<ManagerRole> managerRoles = (List<ManagerRole>) managerRoleService.findManagerRoleByMid(managers.get(i).getManagerId()).getData();
            List<Integer> rids=new ArrayList<Integer>();
            for (ManagerRole mr:managerRoles) {
                rids.add(mr.getRoleId());
            }
            List<Role> roles = (List<Role>) roleService.findRoleListByRids(rids).getData();
            managerPo.setRoles(roles);
            managerPos.add(managerPo);
        }
        return NewsResult.ok(managerPos);

    }


}
