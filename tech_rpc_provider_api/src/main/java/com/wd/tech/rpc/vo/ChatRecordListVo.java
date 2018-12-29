package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/6.
 */
public class ChatRecordListVo implements Serializable {

    private static final long serialVersionUID = 7668872309657733601L;

    private String nickName;
    private String content;
    private Date chatTime;
    private String picUrl;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "ChatRecordListVo{" +
                "nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", chatTime='" + chatTime + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
