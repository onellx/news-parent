package com.news.pojo;

public class FunctionInfo {
    private Integer functionId;

    private String functionName;

    private String functionSite;

    private String functionComment;

    private Integer moduleId;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionSite() {
        return functionSite;
    }

    public void setFunctionSite(String functionSite) {
        this.functionSite = functionSite == null ? null : functionSite.trim();
    }

    public String getFunctionComment() {
        return functionComment;
    }

    public void setFunctionComment(String functionComment) {
        this.functionComment = functionComment == null ? null : functionComment.trim();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}