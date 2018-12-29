package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 社区统计
 * @author: Lzy
 * @create: 2018-09-05 10:57
 **/
public class CommunityCount implements Serializable {

    private int id;

    private int communityId;

    private int praise;

    private int comment;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String
    toString() {
        return "CommunityCount{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", praise=" + praise +
                ", comment=" + comment +
                ", createTime=" + createTime +
                '}';
    }
}
