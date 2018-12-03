package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Article;

/**
 * @ClassName ArticleService
 * @Author One_llx
 * @Date 2018/12/2 0002 下午 3:06
 * @Version 1.0
 */
public interface ArticleService {

    NewsResult findArticleList();

    NewsResult findArticlePoList();

    NewsResult updateArticle(Article article);

    NewsResult findArticleById(Integer id);

    NewsResult saveArticle(Article article);

    NewsResult findAutditAcrticle();

    NewsResult findAutditAcrticlePo();
}
