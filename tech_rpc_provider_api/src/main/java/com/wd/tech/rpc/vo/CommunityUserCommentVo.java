package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 社区用户评论列表
 * @author: Lzy
 * @create: 2018-10-23 15:52
 **/
public class CommunityUserCommentVo implements Serializable {

    private String content;

    private int userId;

    private String nickName;
    //用户头像
    private String headPic;
    //评论时间
    private Date commentTime;

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

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "CommunityUserCommentVo{" +
                "content='" + content + '\'' +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
