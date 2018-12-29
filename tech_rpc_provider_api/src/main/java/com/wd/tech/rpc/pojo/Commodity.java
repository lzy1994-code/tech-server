package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/25.
 */
public class Commodity implements Serializable {

    private static final long serialVersionUID = 6080768947403995299L;

    public final static int TYPE_VIP = 1;

    private int id;
    private String name;
    private int type;
    private double price;
    private String imageUrl;
    private int value;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", value=" + value +
                ", createTime=" + createTime +
                '}';
    }
}
