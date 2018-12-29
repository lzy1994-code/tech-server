package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/6.
 */
public class GroupChatRecordListVo implements Serializable {
    private static final long serialVersionUID = -1799022062150684358L;

    private int userId;
    private String nickName;
    private String headPic;
    private String chatContent;
    private String chatImage;
    private Date chatTime;

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

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getChatImage() {
        return chatImage;
    }

    public void setChatImage(String chatImage) {
        this.chatImage = chatImage;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    @Override
    public String toString() {
        return "GroupChatRecordListVo{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", chatContent='" + chatContent + '\'' +
                ", chatImage='" + chatImage + '\'' +
                ", chatTime=" + chatTime +
                '}';
    }
}
