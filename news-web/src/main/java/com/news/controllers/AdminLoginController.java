package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.pojo.Article;
import com.news.service.ArticleService;
import com.news.service.ManagerService;
import com.news.pojo.Manager;
import com.news.po.NewsResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName AdminLoginController
 * @Author One_llx
 * @Date 2018/11/18 0018 下午 11:04
 * @Version 1.0
 */
@Controller
public class AdminLoginController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loginHtml(Model model){
        return "/login";
    }

    @RequestMapping(value="login",method=RequestMethod.POST)
    @SystemControllerLog(description = "登录新闻系统")
    public String login(Manager manager, HttpSession session, HttpServletRequest request){
        String errorMessage = "";
        UsernamePasswordToken token = null;
        try {
            //1.得到Subject
            Subject subject = SecurityUtils.getSubject();
            //2.调用登录方法
            token = new UsernamePasswordToken(manager.getManagerNumber(), manager.getManagerPasswd());
            subject.login(token);//当这一代码执行时，就会自动跳入到AuthRealm中认证方法
        }catch (UnknownAccountException uae) {
            errorMessage = "用户认证失败:输入的用户不存在!";
        } catch (IncorrectCredentialsException ice) {
            errorMessage = "用户认证失败：密码输入错误!";
             NewsResult.build(400, errorMessage);
        } catch (LockedAccountException lae) {
            errorMessage = "用户认证失败：用户已锁定!";
        } catch (AuthenticationException e) {
            errorMessage = "登录失败错误信息：请检查用户和密码信息!";
            e.printStackTrace();
            token.clear();
        }
        if (!errorMessage.equals("")||errorMessage==null){
            request.setAttribute("message",errorMessage);
            return "login";
        }
        return "login-index";
    }

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(Model model){
        List<Article> articles= (List<Article>) articleService.findAutditAcrticle().getData();
        model.addAttribute("articles",articles);
        return "index";
    }


   @RequestMapping(value="/logouts",method=RequestMethod.GET)
   @SystemControllerLog(description = "退出系统")
   public String logout(RedirectAttributes redirectAttributes){

       Subject subject = SecurityUtils.getSubject();
       if (subject.isAuthenticated()) {
           subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
           //redirectAttributes.addFlashAttribute("message", "您已安全退出");
           return "redirect:/";
       }
       return "redirect:/";
   }





}
