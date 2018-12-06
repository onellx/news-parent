package com.news.po;

import com.news.pojo.Comment;
import com.news.pojo.UserInfo;

/**
 * @ClassName CommentPo
 * @Author One_llx
 * @Date 2018/12/6 0006 上午 2:23
 * @Version 1.0
 */
public class CommentPo {

    private Comment comment;

    private UserInfo userInfo;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
