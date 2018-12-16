package com.news.service.impl;

import com.news.mapper.ArticleMapper;
import com.news.po.ArticlePo;
import com.news.po.ManagerPo;
import com.news.po.NewsResult;
import com.news.pojo.*;
import com.news.service.ArticleService;
import com.news.service.CatalogService;
import com.news.service.DeparmentCatalogService;
import com.news.service.ManagerService;
import com.news.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    @Autowired
    private DeparmentCatalogService deparmentCatalogService;

    @Override
    public NewsResult findArticleList() {
        ArticleExample articleExample=new ArticleExample();
        articleExample.setOrderByClause("article_time desc");
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateIn(StateListUtils.getStateList());
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
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

    @Override
    public NewsResult findArticlePoByCatalogId(Integer id) {
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateIn(StateListUtils.getStateList());
        criteria.andCatalogIdEqualTo(id);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        return this.getArticlePoList(articles);
    }

    @Override
    public NewsResult findArticlePoById(Integer id) {
        ArticlePo articlePo=new ArticlePo();
        Article article= (Article) this.findArticleById(id).getData();
        articlePo.setArticle(article);
        //优化
        ManagerPo manager= (ManagerPo) managerService.findManagerById(article.getManagerId()).getData();
        articlePo.setManager(manager.getManager());
        article.setArticleClicks(article.getArticleClicks()+1);
        this.updateArticle(article);
        return NewsResult.ok(articlePo);
    }

    @Override
    public NewsResult findArticleByClik() {
        ArticleExample articleExample=new ArticleExample();
        articleExample.setOrderByClause("article_clicks desc");
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return NewsResult.ok(articles);
    }

    @Override
    public NewsResult findArticlePoListByDid(Integer did) {
        List<DepartCatalog> departCatalogs= (List<DepartCatalog>) deparmentCatalogService.findDepartmentCatalofListByDid(did).getData();
        List<Integer> cid=new ArrayList<>();
        for (DepartCatalog departCatalog:departCatalogs){
            cid.add(departCatalog.getCatalogId());
        }
        ArticleExample articleExample=new ArticleExample();
        articleExample.setOrderByClause("article_time desc");
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateIn(StateListUtils.getStateList());
        criteria.andCatalogIdIn(cid);
        List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);
        return this.getArticlePoList(articles);
    }

    @Override
    public NewsResult findAuditArticlePoListByDid(Integer did) {
        List<DepartCatalog> departCatalogs= (List<DepartCatalog>) deparmentCatalogService.findDepartmentCatalofListByDid(did).getData();
        List<Integer> cids=new ArrayList<>();
        for (DepartCatalog departCatalog:departCatalogs) {
            cids.add(departCatalog.getCatalogId());
        }
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleStateEqualTo("0");
        criteria.andCatalogIdIn(cids);
        List<Article> articles = articleMapper.selectByExample(articleExample);
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
