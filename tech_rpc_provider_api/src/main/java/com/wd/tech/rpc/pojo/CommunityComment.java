package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 社区评论
 * @author: Lzy
 * @create: 2018-09-05 10:34
 **/
public class CommunityComment implements Serializable {

    private int id;

    private int communityId;

    private String content;

    private int userId;

    private String nickName;

  /*  private int type;

    private int replyUserId;

    private String replyName;*/

    private Date commentTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "CommunityComment{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
