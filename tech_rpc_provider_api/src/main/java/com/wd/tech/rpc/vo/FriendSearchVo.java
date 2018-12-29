package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/10/10.
 */
public class FriendSearchVo implements Serializable {
    private static final long serialVersionUID = 5876658318819508950L;

    private int friendUid;
    private String remarkName;
    private String nickName;
    private String headPic;
    //好友来自哪个群组
    private String buddySource;

    private String userName;
    private String pwd;

    public int getFriendUid() {
        return friendUid;
    }

    public void setFriendUid(int friendUid) {
        this.friendUid = friendUid;
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

    public String getBuddySource() {
        return buddySource;
    }

    public void setBuddySource(String buddySource) {
        this.buddySource = buddySource;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    @Override
    public String toString() {
        return "FriendSearchVo{" +
                "friendUid=" + friendUid +
                ", remarkName='" + remarkName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", buddySource='" + buddySource + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
