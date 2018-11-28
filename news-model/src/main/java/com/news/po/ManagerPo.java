package com.news.po;

import com.news.pojo.DepartmentInfo;
import com.news.pojo.Manager;
import com.news.pojo.Role;

import java.util.List;

/**
 * @ClassName ManagerPo
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 11:03
 * @Version 1.0
 */
public class ManagerPo {

    private Manager manager;

    private List<Role> roles;

    private DepartmentInfo departmentInfo;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }
}
