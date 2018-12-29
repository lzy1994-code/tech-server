package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/8/31.
 */
public class FriendListVo implements Serializable{

    private static final long serialVersionUID = 1899302767073273590L;

    private int friendUid;
    private String nickName;
    private String remarkName;
    private String headPic;
    private int vipFlag;
    private String signature;
    private String userName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(int vipFlag) {
        this.vipFlag = vipFlag;
    }

    public int getFriendUid() {
        return friendUid;
    }

    public void setFriendUid(int friendUid) {
        this.friendUid = friendUid;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FriendListVo{" +
                "friendUid=" + friendUid +
                ", nickName='" + nickName + '\'' +
                ", remarkName='" + remarkName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", vipFlag=" + vipFlag +
                ", signature='" + signature + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
