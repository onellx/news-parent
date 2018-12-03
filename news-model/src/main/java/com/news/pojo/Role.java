package com.news.pojo;

import java.util.Objects;

public class Role {
    private Integer roleId;

    private String roleName;

    private String roleComment;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment == null ? null : roleComment.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getRoleId(), role.getRoleId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoleId(), getRoleName(), getRoleComment());
    }
}