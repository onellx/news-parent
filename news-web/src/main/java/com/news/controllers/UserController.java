package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.NewsResult;
import com.news.pojo.DepartmentInfo;
import com.news.pojo.UserInfo;
import com.news.service.UserService;
import com.news.utils.JsonUtils;
import com.news.utils.LinkedNewsPictureMap;
import com.news.utils.NewsPictureMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:16
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取用户列表")
    public String userList(Model model){
        List<UserInfo> userInfos= (List<UserInfo>) userService.findUserList().getData();
        model.addAttribute("userInfos",userInfos);
        return "user-list";
    }


    @RequestMapping(value="user/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){
        System.out.println(id);
        System.out.println(state);
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(JsonUtils.jsonToPojo(id,Integer.class));
        userInfo.setUserState(state);
        NewsResult newsResult = userService.updateUser(userInfo);
        if (newsResult.getStatus()!=200){
            return "false";
        }
        return "true";
    }

}
