package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Article;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @ClassName ArticleService
 * @Author One_llx
 * @Date 2018/12/2 0002 下午 3:06
 * @Version 1.0
 */
public interface ArticleService {

    /**
     * 获取文章列表
     * @return
     */
    NewsResult findArticleList();

    /**
     * 获取ArticlePo列表
     * @return
     */
    NewsResult findArticlePoList();

    /**
     * 更新文章
     * @param article 要更新的文章对象
     * @return
     */
    NewsResult updateArticle(Article article);

    /**
     * 通过文章Id查找文章
     * @param id 文章id
     * @return
     */
    NewsResult findArticleById(Integer id);

    /**
     * 添加文章
     * @param article 要添加的文章对象
     * @return
     */
    NewsResult saveArticle(Article article);

    /**
     *查找需要审核的文章
     * @return
     */
    NewsResult findAutditAcrticle();

    /**
     * 查找需要审核的ArticlePo
     * @return
     */
    NewsResult findAutditAcrticlePo();

    /**
     * 通过栏目Id查找ArticlePo
     * @param id
     * @return
     */
    NewsResult findArticlePoByCatalogId(Integer id);

    /**
     * 通过文章ID查找ArticlePo
     * @param id
     * @return
     */
    NewsResult findArticlePoById(Integer id);

    /**
     * 按照点击率降序查找所有的文章
     * @return
     */
    NewsResult findArticleByClik();

    /**
     * 根据部门id查找这个部门可操作的ArticlePo
     * @return
     */
    NewsResult findArticlePoListByDid(Integer did);

    /**
     * 根据部门id查找响应的需要审核的新闻
     * @param did
     * @return
     */
    NewsResult findAuditArticlePoListByDid(Integer did);


}
