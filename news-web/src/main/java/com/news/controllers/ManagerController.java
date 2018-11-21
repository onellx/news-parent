package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ManagerPo;
import com.news.po.NewsResult;
import com.news.pojo.Manager;
import com.news.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName ManagerController
 * @Author One_llx
 * @Date 2018/11/20 0020 上午 8:43
 * @Version 1.0
 */
@Controller
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "admin-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取管理员列表")
    public String managerList(Model model){

        NewsResult newsResult = managerService.managerList();
        List<ManagerPo> managers= (List<ManagerPo>) newsResult.getData();
        model.addAttribute("managerpos",managers);
        return "admin-list";
    }
    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    @SystemControllerLog(description = "欢迎页")
    public String welcome(Model model){


        return "welcome";
    }
    
}
