package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/8/31.
 */
public class ChatRecord implements Serializable {

    private static final long serialVersionUID = -3851731918687453813L;

    /**
     *  发送
     */
    public static int DIRECTION_SEND = 1;

    /**
     *  接收
     */
    public static int DIRECTION_RECEIVE = 2;

    private int id;
    private int userId;
    private int friendId;
    private String headPic;
    private int direction;
    private String chatContent;
    private String chatImage;
    private Date chatTime;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendId=" + friendId +
                ", headPic='" + headPic + '\'' +
                ", direction=" + direction +
                ", chatContent='" + chatContent + '\'' +
                ", chatImage='" + chatImage + '\'' +
                ", chatTime=" + chatTime +
                ", createTime=" + createTime +
                '}';
    }

}
