package com.news.po;

import com.news.pojo.Catalog;
import com.news.pojo.DepartmentInfo;

import java.util.List;

/**
 * @ClassName DepartmentPo
 * @Author One_llx
 * @Date 2018/11/28 0028 下午 3:35
 * @Version 1.0
 */
public class DepartmentPo {

    private DepartmentInfo departmentInfo;

    private List<Catalog> catalogs;

    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }
}
