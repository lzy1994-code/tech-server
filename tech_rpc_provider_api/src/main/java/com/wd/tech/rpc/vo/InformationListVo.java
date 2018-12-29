package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 资讯推荐vo
 * @author: Lzy
 * @create: 2018-08-29 14:38
 **/
public class InformationListVo  implements Serializable{

    private int id;
    //标题
    private String title;
    //列表缩略图
    private String thumbnail;
    //来源
    private String source;
    //摘要
    private String summary;
    //发布时间
    private Date releaseTime;
    //收藏数
    private int collection;
    //分享数
    private int share;
    //是否付费(2为免费,1为付费)
    private int whetherPay;
    //当前用户是否收藏 1=是 ，2=否
    private int whetherCollection;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getWhetherPay() {
        return whetherPay;
    }

    public void setWhetherPay(int whetherPay) {
        this.whetherPay = whetherPay;
    }

    public int getWhetherCollection() {
        return whetherCollection;
    }

    public void setWhetherCollection(int whetherCollection) {
        this.whetherCollection = whetherCollection;
    }

    @Override
    public String toString() {
        return "InformationListVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", source='" + source + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseTime=" + releaseTime +
                ", collection=" + collection +
                ", share=" + share +
                ", whetherPay=" + whetherPay +
                ", whetherCollection=" + whetherCollection +
                '}';
    }
}
