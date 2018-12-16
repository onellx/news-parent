package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.DepartmentInfo;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Author One_llx
 * @Date 2018/11/22 0022 下午 5:21
 * @Version 1.0
 */
public interface DepartmentService {
    /**
     *获取所有部门信息
     * @return
     */
    NewsResult findDepartmentList();

    /**
     *获取所有DepartmentPo信息
     * @return
     */
    NewsResult findDepartmentPoList();

    /**
     *更新部门信息
     * @param departmentInfo 部门信息对象
     * @param cids 栏目ids
     * @return
     */
    NewsResult updateDepartment(DepartmentInfo departmentInfo,List<Integer> cids);

    /**
     *更新部门信息
     * @param departmentInfo 部门信息对象
     * @return
     */
    NewsResult updateDepartment(DepartmentInfo departmentInfo);

    /**
     *根据id查找DepartmentPo对象
     * @param deparmentId 部门id
     * @return
     */
    NewsResult findDepartmentPoById(Integer deparmentId);

    /**
     *根据部门id查找部门信息
     * @param deparmentId 部门id
     * @return
     */
    NewsResult findDepartmentById(Integer deparmentId);

    /**
     *根据部门名称查找部门信息
     * @param departmentName 部门名称
     * @return
     */
    NewsResult findDepartmentByName(String departmentName);

    /**
     *添加部门
     * @param departmentInfo 部门信息
     * @param cids 栏目ids
     * @return
     */
    NewsResult saveDepartment(DepartmentInfo departmentInfo, List<Integer> cids);

    /**
     *更新部门联系人名称
     * @param departmentLikman 部门联系人名称
     * @return
     */
    NewsResult updateDepartmentLikman(String departmentLikman);

}
