package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ArticlePo;
import com.news.po.CommentPo;
import com.news.po.NewsPo;
import com.news.pojo.*;
import com.news.service.ArticleService;
import com.news.service.CatalogService;
import com.news.service.CommentService;
import com.news.service.PictureService;
import com.news.utils.HtmlUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NewsController
 * @Author One_llx
 * @Date 2018/12/3 0003 下午 10:22
 * @Version 1.0
 */
@Controller
public class NewsController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    @SystemControllerLog(description = "首页")
    public String index(Model model){
        List<NewsPo> newsPos=new ArrayList<>();
        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("catalogs",catalogs);
        List<Article> articles= (List<Article>) articleService.findArticleList().getData();
        for (Article article:articles){
            NewsPo newsPo=new NewsPo();
            String[] imgs = HtmlUtil.getImgs(article.getArticleContent());
            if (imgs!=null){
                newsPo.setUrl(imgs[0]);
            }
            article.setArticleContent(HtmlUtil.getTextFromHtml(article.getArticleContent()));
            newsPo.setArticle(article);
            newsPos.add(newsPo);
        }
        model.addAttribute("newsPos",newsPos);
        List<Image> images= (List<Image>) pictureService.findPictureList().getData();
        model.addAttribute("images",images);
        List<Article> articlesClick= (List<Article>) articleService.findArticleByClik().getData();
        model.addAttribute("articlesClick",articlesClick);
        return "index";
    }
    @RequestMapping(value = "news/{id}",method = RequestMethod.GET)
    public String findNewsById(@PathVariable Integer id, Model model){

        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("catalogs",catalogs);
        ArticlePo articlePo= (ArticlePo) articleService.findArticlePoById(id).getData();
        model.addAttribute("articlePo",articlePo);
        List<Image> images= (List<Image>) pictureService.findPictureList().getData();
        model.addAttribute("images",images);
        List<CommentPo> commentPos= (List<CommentPo>) commentService.findCommentPoListByArticleid(id).getData();
        model.addAttribute("commentPos",commentPos);
        return "content";
    }

    @RequestMapping(value = "news/like/{id}",method = RequestMethod.GET)
    public String news_like(@PathVariable Integer id){
        System.out.println(id);
        Article article= (Article) articleService.findArticleById(id).getData();
        article.setArticleLike(article.getArticleLike()+1);
        articleService.updateArticle(article);
        //修复ajax
        return "redirect:/news/"+id;
    }

    @RequestMapping(value = "news/catalog/{id}",method = RequestMethod.GET)
    public String news_catalog(@PathVariable Integer id,Model model){
        List<NewsPo> newsPos=new ArrayList<>();
        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("catalogs",catalogs);
        List<ArticlePo> articles= (List<ArticlePo>) articleService.findArticlePoByCatalogId(id).getData();
        System.out.println(articles.size());
        System.out.println(id);
        for (ArticlePo article:articles){
            NewsPo newsPo=new NewsPo();
            String[] imgs = HtmlUtil.getImgs(article.getArticle().getArticleContent());
            if (imgs!=null){
                newsPo.setUrl(imgs[0]);
            }
            article.getArticle().setArticleContent(HtmlUtil.getTextFromHtml(article.getArticle().getArticleContent()));
            newsPo.setArticle(article.getArticle());
            newsPos.add(newsPo);
        }
        model.addAttribute("newsPos",newsPos);
        List<Image> images= (List<Image>) pictureService.findPictureList().getData();
        model.addAttribute("images",images);
        return "newscatalog";
    }

    @RequestMapping(value = "comment",method = RequestMethod.POST)
    public String save_comment(Comment comment){
        Subject subject=SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        comment.setUserId(userInfo.getUserId());
        System.out.println(comment.getCommentContent());
        commentService.saveComment(comment);
        //修复ajax
        return "redirect:/news/"+comment.getArticleId();
    }


}
