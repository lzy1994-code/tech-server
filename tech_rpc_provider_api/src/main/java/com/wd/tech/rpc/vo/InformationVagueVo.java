package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tech-rpc
 * @description: 资讯模糊查询vo
 * @author: Lzy
 * @create: 2018-09-06 09:03
 **/
public class InformationVagueVo implements Serializable{

    private int id;
    //标题
    private String title;
    //来源
    private String source;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "InformationVagueVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", releaseTime=" + releaseTime +
                '}';
    }
}
