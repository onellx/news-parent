package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName ArticleController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:12
 * @Version 1.0
 */
@Controller
public class ArticleController {


    @RequestMapping(value = "article-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取文章列表")
    public String articleList(Model model){

        return "article-list";
    }
}
