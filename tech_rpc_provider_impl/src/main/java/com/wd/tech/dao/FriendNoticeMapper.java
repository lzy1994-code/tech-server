package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.FriendNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
public interface FriendNoticeMapper {

    int addFriendNotice(FriendNotice friendNotice);

    List<FriendNotice> findFriendNoticePageList(@Param("userId") int userId, @Param("index") int index, @Param("count") int count);

    int updateStatus(@Param("id")int id,@Param("status")int status);

    FriendNotice findLastFriendNotice(int userId);

    FriendNotice findFriendNoticeById(int id);

}
