package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 社区评论vo
 * @author: Lzy
 * @create: 2018-09-08 09:27
 **/
public class CommunityCommentVo  implements Serializable  {

    private String content;

    private int userId;

    private String nickName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "CommunityCommentVo{" +
                "content='" + content + '\'' +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
