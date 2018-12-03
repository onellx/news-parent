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

    NewsResult findDepartmentList();

    NewsResult findDepartmentPoList();

    NewsResult updateDepartment(DepartmentInfo departmentInfo,List<Integer> cids);

    NewsResult updateDepartment(DepartmentInfo departmentInfo);

    NewsResult findDepartmentPoById(Integer deparmentId);

    NewsResult findDepartmentByName(String departmentName);

    NewsResult saveDepartment(DepartmentInfo departmentInfo, List<Integer> cids);

    NewsResult updateDepartmentLikman(String departmentLikman);

}
