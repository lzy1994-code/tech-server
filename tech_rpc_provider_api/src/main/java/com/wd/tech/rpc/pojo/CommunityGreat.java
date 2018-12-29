package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 社区点赞
 * @author: Lzy
 * @create: 2018-09-05 10:59
 **/
public class CommunityGreat implements Serializable {

    public static int WHETHER_GREAT_YES = 1;
    public static int WHETHER_GREAT_NO = 2;

    private  int id;

    private int userId;

    private int communityId;

    private Date greatTime;

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

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }


    public Date getGreatTime() {
        return greatTime;
    }

    public void setGreatTime(Date greatTime) {
        this.greatTime = greatTime;
    }

    @Override
    public String toString() {
        return "CommunityGreat{" +
                "id=" + id +
                ", userId=" + userId +
                ", communityId=" + communityId +
                ", greatTime=" + greatTime +
                '}';
    }
}
