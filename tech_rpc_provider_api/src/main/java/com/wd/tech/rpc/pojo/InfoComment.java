package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 资讯评论
 * @author: Lzy
 * @create: 2018-08-28 15:24
 **/
public class InfoComment implements Serializable {
    private int id;
    //资讯id
    private int infoId;
    //用户id
    private int userId;
    //评论内容
    private String content;
    //评论时间
    private Date commentTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "InfoComment{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
