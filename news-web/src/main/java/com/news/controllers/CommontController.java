package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName CommontController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:15
 * @Version 1.0
 */
@Controller
public class CommontController {

    @RequestMapping(value = "feedback-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取评论列表")
    public String commontList(Model model){


        return "comment-list";
    }
}
