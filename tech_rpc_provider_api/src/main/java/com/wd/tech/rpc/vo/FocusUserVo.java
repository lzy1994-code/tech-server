package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 关注用户vo
 * @author: Lzy
 * @create: 2018-09-07 10:47
 **/
public class FocusUserVo implements Serializable{

    public static int whetherMutualFollow_YES = 1;
    public static int whetherMutualFollow_NO = 2;

    //用户id
    private int userId;
    //关注用户id
    private int focusUid;
    //关注时间
    private Date focusTime;
    //被关注用户昵称
    private String nickName;
    //被关注用户头像
    private String headPic;
    //被关注用户签名
    private String signature;
    //被关注用户是否为vip
    private int whetherVip;
    //是否互关(1为是，2为否)
    private int whetherMutualFollow;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFocusUid() {
        return focusUid;
    }

    public void setFocusUid(int focusUid) {
        this.focusUid = focusUid;
    }

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getWhetherVip() {
        return whetherVip;
    }

    public void setWhetherVip(int whetherVip) {
        this.whetherVip = whetherVip;
    }

    public int getWhetherMutualFollow() {
        return whetherMutualFollow;
    }

    public void setWhetherMutualFollow(int whetherMutualFollow) {
        this.whetherMutualFollow = whetherMutualFollow;
    }

    @Override
    public String toString() {
        return "FocusUserVo{" +
                "userId=" + userId +
                ", focusUid=" + focusUid +
                ", focusTime=" + focusTime +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", signature='" + signature + '\'' +
                ", whetherVip=" + whetherVip +
                ", whetherMutualFollow=" + whetherMutualFollow +
                '}';
    }
}
