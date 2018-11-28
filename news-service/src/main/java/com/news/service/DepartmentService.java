package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.DepartmentInfo;

/**
 * @ClassName DepartmentService
 * @Author One_llx
 * @Date 2018/11/22 0022 下午 5:21
 * @Version 1.0
 */
public interface DepartmentService {

    NewsResult departmentList();

    NewsResult departmentPoList();

    NewsResult updateDepartment(DepartmentInfo departmentInfo);
}
