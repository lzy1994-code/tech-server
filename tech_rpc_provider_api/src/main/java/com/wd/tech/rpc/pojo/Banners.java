package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: banner配置
 * @author: Lzy
 * @create: 2018-08-29 14:32
 **/
public class Banners implements Serializable {

    private int id;
   //图片地址
    private String imageUrl;
   //跳转地址 支持两种跳转 分别为原生和H5 原生前缀为wd://  H5前缀为http://
    private String jumpUrl;
    //开始展示时间
    private Date startTime;
    //结束展示时间
    private Date endTime;
    //排序 从小到大排序
    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Banners{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", rank=" + rank +
                '}';
    }
}
