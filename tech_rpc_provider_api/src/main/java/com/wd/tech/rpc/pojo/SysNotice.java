package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/7.
 */
public class SysNotice implements Serializable {

    private static final long serialVersionUID = -1413032411607992708L;

    private int id;
    private int receiveUid;
    private String content;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiveUid() {
        return receiveUid;
    }

    public void setReceiveUid(int receiveUid) {
        this.receiveUid = receiveUid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysNotice{" +
                "id=" + id +
                ", receiveUid=" + receiveUid +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
