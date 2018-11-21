package com.news.pojo;

public class Manager {
    private Integer managerId;

    private String managerName;

    private String managerPasswd;

    private String managerEmail;

    private String managerPhone;

    private String managerState;

    private Integer departmentId;

    private String managerNumber;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPasswd() {
        return managerPasswd;
    }

    public void setManagerPasswd(String managerPasswd) {
        this.managerPasswd = managerPasswd == null ? null : managerPasswd.trim();
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail == null ? null : managerEmail.trim();
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone == null ? null : managerPhone.trim();
    }

    public String getManagerState() {
        return managerState;
    }

    public void setManagerState(String managerState) {
        this.managerState = managerState == null ? null : managerState.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber == null ? null : managerNumber.trim();
    }
}