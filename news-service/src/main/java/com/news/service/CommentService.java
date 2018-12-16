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
    /**
     *获取评论列表
     * @return
     */
    NewsResult findCommentList();

    /**
     *添加评论
     * @param comment
     * @return
     */
    NewsResult saveComment(Comment comment);

    /**
     *获取CommentPo列表
     * @return
     */
    NewsResult findCommentPoList();

    /**
     *通过文章ID查找CommentPo列表
     * @param id
     * @return
     */
    NewsResult findCommentPoListByArticleid(Integer id);

    /**
     *更新评论
     * @param comment 要更新的评论对象
     * @return
     */
    NewsResult updateComment(Comment comment);

    NewsResult findCommentListByDid(Integer did);
}
