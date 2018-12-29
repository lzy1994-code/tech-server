package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 关注用户
 * @author: Lzy
 * @create: 2018-09-06 14:33
 **/
public class FocusUser implements Serializable {

    public static int whetherFollow_YES = 1;
    public static int whetherFollow_NO = 2;

    private int id;
    //用户id
    private int userId;
    //关注用户id
    private int focusUid;
    //关注时间
    private Date focusTime;

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

    @Override
    public String toString() {
        return "FocusUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", focusUid=" + focusUid +
                ", focusTime=" + focusTime +
                '}';
    }
}
