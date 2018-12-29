package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯支付记录
 * @author: Lzy
 * @create: 2018-08-29 08:54
 **/
public class InfoPayRecord implements Serializable{

    private int id;
    //用户id
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
        return "InfoPayRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", infoId=" + infoId +
                '}';
    }
}
