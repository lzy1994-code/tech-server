package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯板块关联类
 * @author: Lzy
 * @create: 2018-08-28 15:01
 **/
public class InformationPlate implements Serializable{

    private int id;
    //板块名称
    private String name;
    //板块图
    private String pic;

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

    @Override
    public String toString() {
        return "InformationPlate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
