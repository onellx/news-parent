package com.news.po;

import com.news.pojo.Article;

/**
 * @ClassName NewsPo
 * @Author One_llx
 * @Date 2018/12/5 0005 下午 9:16
 * @Version 1.0
 */
public class NewsPo {

    private Article article;

    private String url;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
