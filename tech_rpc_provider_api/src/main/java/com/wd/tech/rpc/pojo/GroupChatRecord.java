package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/5.
 */
public class GroupChatRecord implements Serializable {

    private static final long serialVersionUID = -4227452924822021895L;

    private int id;
    private int groupId;
    private int userId;
    private String nickName;
    private String headPic;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

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

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getChatImage() {
        return chatImage;
    }

    public void setChatImage(String chatImage) {
        this.chatImage = chatImage;
    }

    @Override
    public String toString() {
        return "GroupChatRecord{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", chatContent='" + chatContent + '\'' +
                ", chatImage='" + chatImage + '\'' +
                ", chatTime=" + chatTime +
                ", createTime=" + createTime +
                '}';
    }
}
