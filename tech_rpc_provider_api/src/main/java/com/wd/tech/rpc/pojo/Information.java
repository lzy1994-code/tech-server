package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 资讯实体类
 * @author: Lzy
 * @create: 2018-08-28 14:37
 **/
public class Information implements Serializable {

    public static int WHETHER_PAY_YES = 1;
    public static int WHETHER_PAY_NO = 2;

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
    //关联文章ID，多个值逗号间隔
    private String relatedArticles;
    //积分费用  0为免费  大于0为付费内容
    private int integralCost;
    //人民币费用   0为免费  大于0为付费内容
    private double yuanCost;
    //发布时间
    private Date releaseTime;

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

    public String getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(String relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public int getIntegralCost() {
        return integralCost;
    }

    public void setIntegralCost(int integralCost) {
        this.integralCost = integralCost;
    }

    public double getYuanCost() {
        return yuanCost;
    }

    public void setYuanCost(double yuanCost) {
        this.yuanCost = yuanCost;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", relatedArticles='" + relatedArticles + '\'' +
                ", integralCost=" + integralCost +
                ", yuanCost=" + yuanCost +
                ", releaseTime=" + releaseTime +
                '}';
    }
}
