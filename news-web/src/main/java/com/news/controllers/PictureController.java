package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName PictureController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:13
 * @Version 1.0
 */
@Controller
public class PictureController {

    @RequestMapping(value = "picture-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取图片列表")
    public String pictureList(Model model){


        return "picture-list";
    }
}
