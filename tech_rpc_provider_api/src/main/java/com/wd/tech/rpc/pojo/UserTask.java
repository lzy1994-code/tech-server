package com.wd.tech.rpc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xyj on 2018/9/21.
 */
public class UserTask implements Serializable {

    private static final long serialVersionUID = -2683395392029670640L;

    /**
     *  已做
     */
    public final static int STATUS_YES = 1;

    /**
     *  未做
     */
    public final static int STATUS_NO = 2;

    /**
     * 每日任务
     */
    public final static int TYPE_MR = 1;
    /**
     *  一次性任务
     */
    public final static int TYPE_YCX = 2;

    public final static int TASK_MRQD = 1001;
    public final static int TASK_MRSP = 1002;
    public final static int TASK_MRFT = 1003;
    public final static int TASK_MRFX = 1004;
    public final static int TASK_CKGG = 1005;
    public final static int TASK_WSYHXX = 1006;
    public final static int TASK_BDWX = 1007;

    private int id;
    private String name;
    private int type;
    private int integral;
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

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", integral=" + integral +
                ", createTime=" + createTime +
                '}';
    }

}
