package com.wd.tech.rpc.vo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: banner
 * @author: Lzy
 * @create: 2018-09-27 08:59
 **/
public class BannersVo implements Serializable {

    //图片地址
    private String imageUrl;
    //跳转地址 支持两种跳转 分别为原生和H5 原生前缀为wd://  H5前缀为http://
    private String jumpUrl;
    //排序
    private int rank;
    //标题
    private String title;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BannersVo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                '}';
    }
}
