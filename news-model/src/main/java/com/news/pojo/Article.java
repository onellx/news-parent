package com.news.pojo;

import java.util.Date;

public class Article {
    //id
    private Integer articleId;
    //栏目号
    private Integer catalogId;
    //新闻号
    private String articleNumber;
    //新闻标题
    private String articleTitle;
    //管理员号
    private Integer managerId;
    //时间
    private Date articleTime;
    //状态
    private String articleState;
    //点击率
    private Integer articleClicks;
    //点赞数
    private Integer articleLike;
    //内容
    private String articleContent;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber == null ? null : articleNumber.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleState() {
        return articleState;
    }

    public void setArticleState(String articleState) {
        this.articleState = articleState == null ? null : articleState.trim();
    }

    public Integer getArticleClicks() {
        return articleClicks;
    }

    public void setArticleClicks(Integer articleClicks) {
        this.articleClicks = articleClicks;
    }

    public Integer getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(Integer articleLike) {
        this.articleLike = articleLike;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}