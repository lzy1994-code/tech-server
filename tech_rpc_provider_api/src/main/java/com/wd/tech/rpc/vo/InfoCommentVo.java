package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 资讯评论vo
 * @author: Lzy
 * @create: 2018-09-12 15:36
 **/
public class InfoCommentVo implements Serializable {
    private int id;
    //资讯id
    private int infoId;
    //评论者昵称
    private String nickName;
    //用户头像
    private String headPic;
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
        return "InfoCommentVo{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
