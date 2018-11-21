package com.news.po;

import com.news.pojo.DepartmentInfo;
import com.news.pojo.Manager;
import com.news.pojo.ManagerRole;
import com.news.pojo.Role;

/**
 * @ClassName ManagerPo
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 11:03
 * @Version 1.0
 */
public class ManagerPo {

    private Manager manager;

    private Role role;

    private DepartmentInfo departmentInfo;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }
}
