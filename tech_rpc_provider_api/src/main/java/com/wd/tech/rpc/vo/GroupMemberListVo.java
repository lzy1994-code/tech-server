package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/6.
 */
public class GroupMemberListVo implements Serializable {
    private static final long serialVersionUID = -3358860222762793404L;

    private int userId;
    private String headPic;
    private String nickName;
    private int role;

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GroupMemberListVo{" +
                "userId=" + userId +
                ", headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", role=" + role +
                '}';
    }
}
