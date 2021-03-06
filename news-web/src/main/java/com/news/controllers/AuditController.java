package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ArticlePo;
import com.news.pojo.Article;
import com.news.pojo.Manager;
import com.news.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName AuditController
 * @Author One_llx
 * @Date 2018/12/3 0003 下午 8:34
 * @Version 1.0
 */
@Controller
public class AuditController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "audit-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "审核信息页面")
    public String auditList(Model model){
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        if (manager.getDepartmentId()==1){
            List<ArticlePo> articlePos= (List<ArticlePo>) articleService.findAutditAcrticlePo().getData();
            model.addAttribute("articlePos",articlePos);
        }else{
            List<ArticlePo> articlePos= (List<ArticlePo>) articleService.findAuditArticlePoListByDid(manager.getDepartmentId()).getData();
            model.addAttribute("articlePos",articlePos);
        }
        return "audit-list";
    }

}
