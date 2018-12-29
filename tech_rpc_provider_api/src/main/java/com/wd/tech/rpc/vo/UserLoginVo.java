package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/3.
 */
public class UserLoginVo implements Serializable {

    private static final long serialVersionUID = 3757732907820187832L;

    private int userId;

    private String sessionId;

    private String userName;

    private String nickName;

    private String phone;

    private String pwd;

    private String headPic;

    private int whetherVip;

    private String signature;

    private int whetherFaceId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getWhetherVip() {
        return whetherVip;
    }

    public void setWhetherVip(int whetherVip) {
        this.whetherVip = whetherVip;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getWhetherFaceId() {
        return whetherFaceId;
    }

    public void setWhetherFaceId(int whetherFaceId) {
        this.whetherFaceId = whetherFaceId;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headPic='" + headPic + '\'' +
                ", whetherVip=" + whetherVip +
                ", signature='" + signature + '\'' +
                ", whetherFaceId=" + whetherFaceId +
                '}';
    }
}
