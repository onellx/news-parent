package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Comment;

/**
 * @ClassName CommentService
 * @Author One_llx
 * @Date 2018/12/6 0006 上午 2:13
 * @Version 1.0
 */
public interface CommentService {

    NewsResult findCommentList();

    NewsResult saveComment(Comment comment);

    NewsResult findCommentPoList();

    NewsResult findCommentPoListByArticleid(Integer id);

    NewsResult updateComment(Comment comment);
}
