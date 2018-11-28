package com.news.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

public class DepartmentInfo {
    private Integer departmentId;

    private String departmentName;

    private String departmentPhone;

    private String departmentIntro;


    private Date departmentTime;

    private String departmentState;

    private String departmentLikman;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone == null ? null : departmentPhone.trim();
    }

    public String getDepartmentIntro() {
        return departmentIntro;
    }

    public void setDepartmentIntro(String departmentIntro) {
        this.departmentIntro = departmentIntro == null ? null : departmentIntro.trim();
    }

    public Date getDepartmentTime() {
        return departmentTime;
    }

    public void setDepartmentTime(Date departmentTime) {
        this.departmentTime = departmentTime;
    }

    public String getDepartmentState() {
        return departmentState;
    }

    public void setDepartmentState(String departmentState) {
        this.departmentState = departmentState == null ? null : departmentState.trim();
    }

    public String getDepartmentLikman() {
        return departmentLikman;
    }

    public void setDepartmentLikman(String departmentLikman) {
        this.departmentLikman = departmentLikman == null ? null : departmentLikman.trim();
    }
}