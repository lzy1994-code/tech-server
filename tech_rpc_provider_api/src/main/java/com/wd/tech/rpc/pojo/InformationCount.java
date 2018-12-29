package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯信息统计
 * @author: Lzy
 * @create: 2018-08-29 11:47
 **/
public class InformationCount implements Serializable {

    private int id;
    //资讯id
    private int info_id;
    //分享数
    private int share;
    //点赞数
    private int praise;
    //收藏数
    private int collection;
    //评论数
    private int comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "InformationCount{" +
                "id=" + id +
                ", info_id=" + info_id +
                ", share=" + share +
                ", praise=" + praise +
                ", collection=" + collection +
                ", comment=" + comment +
                '}';
    }
}
