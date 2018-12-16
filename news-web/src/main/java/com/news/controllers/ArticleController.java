package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ArticlePo;
import com.news.po.NewsResult;
import com.news.pojo.Article;
import com.news.pojo.Catalog;
import com.news.pojo.Manager;
import com.news.pojo.Role;
import com.news.service.ArticleService;
import com.news.service.CatalogService;
import com.news.service.DeparmentCatalogService;
import com.news.utils.JsonUtils;
import com.news.utils.SysConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @Autowired
    private DeparmentCatalogService deparmentCatalogService;


    @RequestMapping(value = "article-list/{cid}",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取文章列表")
    public String articleList(Model model,@PathVariable Integer cid){
        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
        List<ArticlePo> articlePos=null;
        if(cid==0){
            articlePos= (List<ArticlePo>) articleService.findArticlePoList().getData();
        }else {
            articlePos= (List<ArticlePo>) articleService.findArticlePoByCatalogId(cid).getData();
        }
        model.addAttribute("cid",cid);
        model.addAttribute("articlePos",articlePos);
        model.addAttribute("catalogs",catalogs);
        return "article-list";
    }

    @RequestMapping(value = "article-department-list/{cid}",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取部门文章列表")
    public String articleListByDepartment(Model model,@PathVariable Integer cid){
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogListByDid(manager.getDepartmentId()).getData();
        List<ArticlePo> articlePos=null;
        if(cid==0){
            articlePos= (List<ArticlePo>) articleService.findArticlePoListByDid(manager.getDepartmentId()).getData();
        }else {
            articlePos= (List<ArticlePo>) articleService.findArticlePoByCatalogId(cid).getData();
        }
        model.addAttribute("cid",cid);
        model.addAttribute("catalogs",catalogs);
        model.addAttribute("articlePos",articlePos);
        return "article-department-list";
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
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        if (manager.getDepartmentId()==1){
            Article article= (Article) articleService.findArticleById(id).getData();
            List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
            model.addAttribute("article",article);
            model.addAttribute("catalogs",catalogs);
        }else{
            Article article= (Article) articleService.findArticleById(id).getData();
            List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogListByDid(manager.getDepartmentId()).getData();
            model.addAttribute("article",article);
            model.addAttribute("catalogs",catalogs);
        }
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
        Role role = (Role) subject.getSession().getAttribute(SysConstant.CURRENT_MANAGER_ROLE);
        System.out.println(role.getRoleId());
        if (role.getRoleId()==3){
            article.setArticleState("0");
        }else {
            article.setArticleState("1");
        }
        NewsResult newsResult = articleService.saveArticle(article);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "article-add",method = RequestMethod.GET)
    @SystemControllerLog(description = "添加新闻信息页面")
    public String articleToAdd(Model model){
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        if(manager.getDepartmentId()==1){
            List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
            model.addAttribute("catalogs",catalogs);
        }else{

            List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogListByDid(manager.getDepartmentId()).getData();
            model.addAttribute("catalogs",catalogs);
        }
        return "article-add";
    }

}
