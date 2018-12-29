package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/28.
 */
public class Prize implements Serializable {

    private static final long serialVersionUID = -817156783244029488L;

    /**
     *  虚拟奖品
     */
    public final static int TYPE_XN = 1;

    /**
     *  实物奖品
     */
    public final static int TYPE_SW = 2;

    private int id;
    private String name;
    private String pic;
    private int type;
    private int value;
    private int weight;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", weight=" + weight +
                ", createTime=" + createTime +
                '}';
    }
}
