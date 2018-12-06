package com.news.service.impl;

import com.news.mapper.CommentMapper;
import com.news.po.CommentPo;
import com.news.po.NewsResult;
import com.news.pojo.Comment;
import com.news.pojo.CommentExample;
import com.news.pojo.UserInfo;
import com.news.service.CommentService;
import com.news.service.UserService;
import com.news.utils.StateListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName CommentServiceImpl
 * @Author One_llx
 * @Date 2018/12/6 0006 上午 2:15
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;

    @Override
    public NewsResult findCommentList() {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentStateIn(StateListUtils.getStateList());
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        return NewsResult.ok(comments);
    }

    @Override
    public NewsResult saveComment(Comment comment) {
        comment.setCommentState("1");
        comment.setCommentTime(new Date());
        commentMapper.insert(comment);
        return null;
    }

    @Override
    public NewsResult findCommentPoList() {
        List<Comment> comments= (List<Comment>) this.findCommentList().getData();
        return this.getCommentPoList(comments);
    }

    @Override
    public NewsResult findCommentPoListByArticleid(Integer id) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentStateIn(StateListUtils.getStateList());
        criteria.andArticleIdEqualTo(id);
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        return this.getCommentPoList(comments);
    }

    @Override
    public NewsResult updateComment(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
        return null;
    }

    private NewsResult getCommentPoList(List<Comment> comments){
        List<CommentPo> commentPos=new ArrayList<>();
        List<UserInfo> userInfos= (List<UserInfo>) userService.findUserList().getData();
        Map<Integer,UserInfo> map=userInfos.stream().collect(Collectors.toMap(UserInfo::getUserId,a->a,(k1,k2)->k1));
        for (Comment comment:comments) {
           CommentPo commentPo=new CommentPo();
           commentPo.setComment(comment);
           commentPo.setUserInfo(map.get(comment.getUserId()));
           commentPos.add(commentPo);
        }

        return NewsResult.ok(commentPos);

    }
}
