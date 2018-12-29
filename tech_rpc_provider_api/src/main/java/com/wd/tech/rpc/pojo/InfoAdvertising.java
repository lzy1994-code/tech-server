package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯广告
 * @author: Lzy
 * @create: 2018-08-28 15:08
 **/
public class InfoAdvertising implements Serializable {

    private int id;
    //广告图片
    private String pic;
    //跳转链接
    private String url;
    //广告文案
    private String content;
    //开始时间
    private String startTime;
    //结束时间
    private  String endTime;
    //权重
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "InfoAdvertising{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", weight=" + weight +
                '}';
    }
}
