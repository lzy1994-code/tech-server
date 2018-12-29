package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/6.
 */
public class DialogueRecordListVo implements Serializable {

    private static final long serialVersionUID = -1464532618825018612L;

    private int userId;
    private String headPic;
    private String content;
    private String picUrl;
    private int direction;
    private Date chatTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    @Override
    public String toString() {
        return "DialogueRecordListVo{" +
                "userId=" + userId +
                ", headPic='" + headPic + '\'' +
                ", content='" + content + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", direction=" + direction +
                ", chatTime=" + chatTime +
                '}';
    }

}
