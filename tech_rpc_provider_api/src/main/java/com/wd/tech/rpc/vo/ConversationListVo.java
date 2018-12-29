package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * Created by xyj on 2018/9/18.
 */
public class ConversationListVo implements Serializable {

    private int userId;
    private String userName;
    private String nickName;
    //加密后的
    private String pwd;
    private String headPic;

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

    @Override
    public String toString() {
        return "ConversationListVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headPic='" + headPic + '\'' +
                '}';
    }
}
