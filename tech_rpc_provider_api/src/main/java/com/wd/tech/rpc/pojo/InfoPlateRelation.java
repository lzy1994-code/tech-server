package com.wd.tech.rpc.pojo;

import java.io.Serializable;

/**
 * @program: tech-rpc
 * @description: 资讯板块关系
 * @author: Lzy
 * @create: 2018-08-29 08:26
 **/
public class InfoPlateRelation implements Serializable{

    private int id;
    //资讯id
    private int infoId;
    //板块id
    private int plateId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public String toString() {
        return "InfoPlateRelation{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", plateId=" + plateId +
                '}';
    }
}
