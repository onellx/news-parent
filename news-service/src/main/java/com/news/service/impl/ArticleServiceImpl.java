package com.news.service.impl;

import com.news.mapper.ArticleMapper;
import com.news.po.ArticlePo;
import com.news.po.NewsResult;
import com.news.pojo.Article;
import com.news.pojo.ArticleExample;
import com.news.pojo.Catalog;
import com.news.pojo.Manager;
import com.news.service.ArticleService;
import com.news.service.CatalogService;
import com.news.service.ManagerService;
import com.news.utils.StateListUtils;
import com.news.utils.SysConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ArticleServiceImpl
 * @Author One_llx
 * @Date 2018/12/2 0002 下午 3:07
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CatalogService catalogService;


    @Override
    public NewsResult findArticleList() {
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateIn(StateListUtils.getStateList());
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return NewsResult.ok(articles);
    }

    @Override
    public NewsResult findArticlePoList() {
        List<Article> articles= (List<Article>) this.findArticleList().getData();
        return this.getArticlePoList(articles);
    }




    @Override
    public NewsResult updateArticle(Article article) {
        article.setArticleTime(new Date());
        articleMapper.updateByPrimaryKeySelective(article);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findArticleById(Integer id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return NewsResult.ok(article);
    }

    @Override
    public NewsResult saveArticle(Article article) {
        article.setArticleState("1");
        article.setArticleTime(new Date());
        article.setArticleClicks(0);
        article.setArticleLike(0);
        articleMapper.insertSelective(article);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findAutditAcrticle() {
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateEqualTo("0");
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return NewsResult.ok(articles);
    }

    @Override
    public NewsResult findAutditAcrticlePo() {
        List<Article> articles= (List<Article>) this.findAutditAcrticle().getData();
        return this.getArticlePoList(articles);
    }

    private NewsResult getArticlePoList(List<Article> articles){
        List<ArticlePo> articlePos=new ArrayList<>();
        if (!articles.isEmpty()){
            List<Manager> managers= (List<Manager>) managerService.findManagerList().getData();
            List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
            Map<Integer,Manager> managerMap=managers.stream().collect(Collectors.toMap(Manager::getManagerId,a->a,(k1,k2)->k1));
            Map<Integer,Catalog> catalogMap=catalogs.stream().collect(Collectors.toMap(Catalog::getCatalogId,a->a,(k1,k2)->k1));
            for (Article article:articles) {
                ArticlePo articlePo=new ArticlePo();
                articlePo.setArticle(article);
                articlePo.setCatalog(catalogMap.get(article.getCatalogId()));
                articlePo.setManager(managerMap.get(article.getManagerId()));
                articlePos.add(articlePo);
            }
        }
        return NewsResult.ok(articlePos);
    }
}
