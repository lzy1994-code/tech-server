package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 社区帖子用户信息实体类
 * @author: Lzy
 * @create: 2018-10-22 14:37
 **/
public class CommunityUserVo implements Serializable {
    //用户id
    private int userId;
    //用户头像
    private String headPic;
    //用户昵称
    private String nickName;
    //用户个性签名
    private String signature;
    //当前登录用户是否关注作者(2为否，1为是)
    private int whetherFollow;
    //判断发帖者与用户的关系
    private int whetherMyFriend;
    //权限（用于判断当前用户是否有对此帖子进行修改删除等的权限 1=是，2=否）
    private int power;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getWhetherFollow() {
        return whetherFollow;
    }

    public void setWhetherFollow(int whetherFollow) {
        this.whetherFollow = whetherFollow;
    }

    public int getWhetherMyFriend() {
        return whetherMyFriend;
    }

    public void setWhetherMyFriend(int whetherMyFriend) {
        this.whetherMyFriend = whetherMyFriend;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "CommunityUserVo{" +
                "userId=" + userId +
                ", headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signature='" + signature + '\'' +
                ", whetherFollow=" + whetherFollow +
                ", whetherMyFriend=" + whetherMyFriend +
                ", power=" + power +
                '}';
    }
}
