package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 广告vo
 * @author: Lzy
 * @create: 2018-09-27 15:05
 **/
public class InfoAdvertisingVo implements Serializable {

    private int id;
    //广告图片
    private String pic;
    //跳转链接
    private String url;
    //广告文案
    private String content;

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

    @Override
    public String toString() {
        return "InfoAdvertisingVo{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
