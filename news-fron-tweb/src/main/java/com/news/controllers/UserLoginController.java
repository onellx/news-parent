package com.news.controllers;

import com.news.po.NewsResult;
import com.news.pojo.UserInfo;
import com.news.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserLoginController
 * @Author One_llx
 * @Date 2018/12/3 0003 下午 10:22
 * @Version 1.0
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "tologin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, Model model){
        UsernamePasswordToken token = null;
        String errorMessage="";
        try {
            //1.得到Subject
            Subject subject = SecurityUtils.getSubject();
            //2.调用登录方法
            token = new UsernamePasswordToken(userInfo.getUserEmail(), userInfo.getUserPasswd());
            subject.login(token);//当这一代码执行时，就会自动跳入到AuthRealm中认证方法
        }catch (AuthenticationException e) {
            errorMessage = "登录失败错误信息：请检查用户和密码信息!";
            e.printStackTrace();
            token.clear();
        }
        model.addAttribute("message",errorMessage);
        if (!errorMessage.equals("")||errorMessage==null){
            return "login";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(UserInfo userInfo,Model model){
        userService.saveUser(userInfo);
        model.addAttribute("message2","注册成功！");
        return "login";
    }

}
