package com.wd.tech.service;

import com.wd.tech.rpc.pojo.ChatRecord;

import java.util.List;

/**
 * Created by xyj on 2018/8/31.
 */
public interface ChatRecordService {

    /**
     *  保存聊天记录
     * @param sendUid 发送用户
     * @param receiveUid 接收用户
     * @param content 聊天内容
     * @param chatImage 聊天图片
     * @return
     */
    int saveChatRecord(int sendUid,int receiveUid,String content,String chatImage);

    /**
     *  查询最后一条聊天记录
     * @param userId
     * @param friend
     * @return
     */
    ChatRecord findLastRecord(int userId,int friend);

    /**
     *  查询与聊天记录
     * @param userId
     * @param friend
     * @param page
     * @param count
     * @return
     */
    List<ChatRecord> findChatRecordPageList(int userId,int friend,int page,int count);

    /**
     *  同步好友聊天记录
     * @param userId
     * @param friend
     * @param month 传1表示同步1个月内的聊天记录
     * @return
     */
    List<ChatRecord> syncChatHistory(int userId,int friend,int month);

    /**
     *  删除好友聊天记录
     * @param userId
     * @param friend
     * @return
     */
    int deleteChatRecord(int userId,int friend);

}
