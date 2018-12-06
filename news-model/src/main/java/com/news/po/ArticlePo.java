package com.news.po;

import com.news.pojo.Article;
import com.news.pojo.Catalog;
import com.news.pojo.Manager;

/**
 * @ClassName ArticlePo
 * @Author One_llx
 * @Date 2018/12/2 0002 下午 3:04
 * @Version 1.0
 */
public class ArticlePo {

    private Article article;

    private Manager manager;

    private Catalog catalog;



    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
