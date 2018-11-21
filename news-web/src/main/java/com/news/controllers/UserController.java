package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:16
 * @Version 1.0
 */
@Controller
public class UserController {

    @RequestMapping(value = "user-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取用户列表")
    public String userList(Model model){


        return "user-list";
    }
}
