package com.wd.tech.rpc.vo;

import com.wd.tech.rpc.pojo.InformationPlate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯详情展示vo
 * @author: Lzy
 * @create: 2018-08-29 09:17
 **/
public class InformationVo implements Serializable {
    private  int id;
    //标题
    private  String title;
    //摘要
    private String summary;
    //正文
    private String content;
    //来源
    private String source;
    //列表缩略图
    private String thumbnail;
    //推荐阅读关联id
    private String relatedArticles;
    //推荐阅读
    private List<RecommendReadVo> informationList;
    //发布时间
    private Date releaseTime;
    //评论数
    private int comment;
    //点赞数
    private  int praise;
    //当前用户是否过点赞 1=是 ，2=否
    private int whetherGreat;
    //当前用户是否收藏 1=是 ，2=否
    private int whetherCollection;
    //所属板块
    private List<InformationPlate> plate;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public List<InformationPlate> getPlate() {
        return plate;
    }

    public void setPlate(List<InformationPlate> plate) {
        this.plate = plate;
    }

    public String getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(String relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public List<RecommendReadVo> getInformationList() {
        return informationList;
    }

    public void setInformationList(List<RecommendReadVo> informationList) {
        this.informationList = informationList;
    }

    public int getWhetherGreat() {
        return whetherGreat;
    }

    public void setWhetherGreat(int whetherGreat) {
        this.whetherGreat = whetherGreat;
    }

    public int getWhetherCollection() {
        return whetherCollection;
    }

    public void setWhetherCollection(int whetherCollection) {
        this.whetherCollection = whetherCollection;
    }

    @Override
    public String toString() {
        return "InformationVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", relatedArticles='" + relatedArticles + '\'' +
                ", informationList=" + informationList +
                ", releaseTime=" + releaseTime +
                ", comment=" + comment +
                ", praise=" + praise +
                ", whetherGreat=" + whetherGreat +
                ", whetherCollection=" + whetherCollection +
                ", plate=" + plate +
                '}';
    }
}
