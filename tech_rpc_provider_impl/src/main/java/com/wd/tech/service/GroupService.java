package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Groups;

import java.util.List;

/**
 * Created by xyj on 2018/9/4.
 */
public interface GroupService {

    /**
     *  创建群组
     * @param name
     * @param description
     * @param ownerUid
     * @param maxCount
     * @return
     */
    int createGroup(String name,String description,int ownerUid,int maxCount);

    /**
     *  修改群组名
     * @param id
     * @param groupName
     * @return
     */
    int modifyGroupName(int id,String groupName);

    /**
     *  修改群备注
     * @param id
     * @param description
     * @return
     */
    int modifyGroupDescription(int id,String description);

    /**
     *  修改群人数
     * @param id
     * @param num
     * @return
     */
    int modifyGroupUserNumber(int id,int num);

    /**
     * 解散群组
     * @param id
     * @return
     */
    int disbandGroup(int id,int userId);

    /**
     *  查询我创建的群组
     * @param userId
     * @return
     */
    List<Groups> findGroupsByUserId(int userId);

    /**
     *  查询我加入的所有群组
     * @param userId
     * @return
     */
    List<Groups> findUserJoinedGroup(int userId);

    /**
     *  根据ID查询群组信息
     * @param id
     * @return
     */
    Groups getGroupById(int id);

    /**
     *  查询群组当前人数
     * @param id
     * @return
     */
    int getGroupCurrentCount(int id);

    /**
     * 修改群头像
     * @param image
     * @param groupId
     * @return
     */
    int modifyImage(String image,int groupId);

}
