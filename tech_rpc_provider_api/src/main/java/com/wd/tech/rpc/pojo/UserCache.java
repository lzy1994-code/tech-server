package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/7.
 */
public class UserCache implements Serializable {

    private static final long serialVersionUID = -6876307872612333619L;

    private int userId;
    private String userName;
    private String nickName;
    private String phone;
    private String pwd;
    private int sex;
    private String signature;
    private String email;
    private String headPic;
    private Date birthday;
    private Date lastLoginTime;
    private int whetherVip;
    private int integral;
    //VIP到期时间
    private Date vipExpireDate;

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getWhetherVip() {
        return whetherVip;
    }

    public void setWhetherVip(int whetherVip) {
        this.whetherVip = whetherVip;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public Date getVipExpireDate() {
        return vipExpireDate;
    }

    public void setVipExpireDate(Date vipExpireDate) {
        this.vipExpireDate = vipExpireDate;
    }

    public int getWhetherFaceId() {
        return whetherFaceId;
    }

    public void setWhetherFaceId(int whetherFaceId) {
        this.whetherFaceId = whetherFaceId;
    }

    @Override
    public String toString() {
        return "UserCache{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", signature='" + signature + '\'' +
                ", email='" + email + '\'' +
                ", headPic='" + headPic + '\'' +
                ", birthday=" + birthday +
                ", lastLoginTime=" + lastLoginTime +
                ", whetherVip=" + whetherVip +
                ", integral=" + integral +
                ", vipExpireDate=" + vipExpireDate +
                ", whetherFaceId=" + whetherFaceId +
                '}';
    }
}
