package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯点赞
 * @author: Lzy
 * @create: 2018-08-28 15:31
 **/
public class InfoGreat implements Serializable{

    public static int WHETHER_GREAT_YES = 1;
    public static int WHETHER_GREAT_NO = 2;

    private int id;
    //点赞用户id
    private int userId;
    //资讯id
    private int infoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Override
    public String toString() {
        return "InfoGreat{" +
                "id=" + id +
                ", userId=" + userId +
                ", infoId=" + infoId +
                '}';
    }
}
