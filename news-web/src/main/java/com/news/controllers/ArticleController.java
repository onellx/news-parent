package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ArticlePo;
import com.news.po.NewsResult;
import com.news.pojo.Article;
import com.news.pojo.Catalog;
import com.news.pojo.Manager;
import com.news.service.ArticleService;
import com.news.service.CatalogService;
import com.news.utils.JsonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @ClassName ArticleController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:12
 * @Version 1.0
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CatalogService catalogService;


    @RequestMapping(value = "article-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取文章列表")
    public String articleList(Model model){
        List<ArticlePo> articlePos= (List<ArticlePo>) articleService.findArticlePoList().getData();
        model.addAttribute("articlePos",articlePos);
        return "article-list";
    }

    @RequestMapping(value="article/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){
        Article article=new Article();
        article.setArticleId(JsonUtils.jsonToPojo(id,Integer.class));
        article.setArticleState(state);
        NewsResult newsResult = articleService.updateArticle(article);
        if (newsResult.getStatus()!=200){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "article-edit/{id}",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改新闻信息页面")
    public String editCatalog(Model model, @PathVariable Integer id){
        Article article= (Article) articleService.findArticleById(id).getData();
        List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("article",article);
        model.addAttribute("catalogs",catalogs);
        return "article-edit";
    }

    @RequestMapping(value="article/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String article_update(Article article){
        NewsResult newsResult = articleService.updateArticle(article);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "article/save",method = RequestMethod.POST)
    @ResponseBody
    public String article_save(Article article){
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        article.setManagerId(manager.getManagerId());

        NewsResult newsResult = articleService.saveArticle(article);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "article-add",method = RequestMethod.GET)
    @SystemControllerLog(description = "添加新闻信息页面")
    public String articleToAdd(Model model){
        List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("catalogs",catalogs);
        return "article-add";
    }
}
