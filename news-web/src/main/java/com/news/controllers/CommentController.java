package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.CommentPo;
import com.news.po.NewsResult;
import com.news.pojo.Comment;
import com.news.service.CommentService;
import com.news.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @ClassName CommentController
 * @Author One_llx
 * @Date 2018/12/6 0006 上午 2:56
 * @Version 1.0
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "comment-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取评论列表")
    public String commentList(Model model){
        NewsResult newsResult = commentService.findCommentPoList();
        List<CommentPo> commentPoList= (List<CommentPo>) newsResult.getData();
        System.out.println(commentPoList.size());
        model.addAttribute("commentPoList",commentPoList);
        return "comment-list";
    }


    @RequestMapping(value="comment/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){

        Comment comment=new Comment();
        comment.setCommentId(JsonUtils.jsonToPojo(id,Integer.class));
        comment.setCommentState(state);
        commentService.updateComment(comment);
        return "true";
    }
}
