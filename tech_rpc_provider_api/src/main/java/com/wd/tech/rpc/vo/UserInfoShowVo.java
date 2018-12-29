package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/6.
 */
public class UserInfoShowVo implements Serializable {

    private static final long serialVersionUID = -6004272743551699249L;

    private int userId;
    private String nickName;
    private String userName;
    private String phone;
    private int sex;
    private String signature;
    private String email;
    private String headPic;
    private Date birthday;
    private int whetherVip;
    private int integral;
    //VIP到期时间
    private Date vipExpireDate;

    private int whetherFaceId;

    //创建的分组
    List<GroupListVo> myGroupList;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<GroupListVo> getMyGroupList() {
        return myGroupList;
    }

    public void setMyGroupList(List<GroupListVo> myGroupList) {
        this.myGroupList = myGroupList;
    }

    public int getWhetherFaceId() {
        return whetherFaceId;
    }

    public void setWhetherFaceId(int whetherFaceId) {
        this.whetherFaceId = whetherFaceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfoShowVo{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", signature='" + signature + '\'' +
                ", email='" + email + '\'' +
                ", headPic='" + headPic + '\'' +
                ", birthday=" + birthday +
                ", whetherVip=" + whetherVip +
                ", integral=" + integral +
                ", vipExpireDate=" + vipExpireDate +
                ", whetherFaceId=" + whetherFaceId +
                ", myGroupList=" + myGroupList +
                '}';
    }
}
