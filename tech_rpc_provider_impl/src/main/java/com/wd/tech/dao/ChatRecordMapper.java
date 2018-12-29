package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.ChatRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/8/31.
 */
public interface ChatRecordMapper {

    int batchAddChatRecord(List<ChatRecord> list);

    ChatRecord findLastRecord(@Param("userId") int userId,@Param("friend") int friend);

    List<ChatRecord> findChatRecordPageList(@Param("userId") int userId,@Param("friend") int friend,@Param("index") int index, @Param("count") int count);

    List<ChatRecord> findChatHistory(@Param("userId") int userId,@Param("friend") int friend,@Param("time") String time);

    int deleteChatRecord(@Param("userId") int userId,@Param("friend") int friend);

}
