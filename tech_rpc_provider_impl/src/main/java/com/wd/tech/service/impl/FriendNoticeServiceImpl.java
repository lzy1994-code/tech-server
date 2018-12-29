package com.wd.tech.service.impl;

import com.wd.tech.dao.FriendNoticeMapper;
import com.wd.tech.rpc.pojo.FriendNotice;
import com.wd.tech.service.FriendNoticeService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
@Service("friendNoticeService")
public class FriendNoticeServiceImpl implements FriendNoticeService {

    @Resource
    private FriendNoticeMapper friendNoticeMapper;

    @Override
    public int increaseFriendNotice(int fromUid, int receiveUid, String remark) {
        FriendNotice friendNotice = new FriendNotice();
        friendNotice.setFromUid(fromUid);
        friendNotice.setReceiveUid(receiveUid);
        friendNotice.setRemark(remark);
        friendNotice.setStatus(FriendNotice.STATUS_DCL);
        friendNotice.setNoticeTime(new Date());
        return friendNoticeMapper.addFriendNotice(friendNotice);
    }

    @Override
    public List<FriendNotice> findFriendNoticePageList(int receiveUid, int page, int count) {
        return friendNoticeMapper.findFriendNoticePageList(receiveUid, CommonUtil.getPageIndex(page, count),count);
    }

    @Override
    public int pass(int id) {
        return friendNoticeMapper.updateStatus(id,FriendNotice.STATUS_TG);
    }

    @Override
    public int reject(int id) {
        return friendNoticeMapper.updateStatus(id,FriendNotice.STATUS_JJ);
    }

    @Override
    public FriendNotice findLastFriendNotice(int userId) {
        return friendNoticeMapper.findLastFriendNotice(userId);
    }

    @Override
    public FriendNotice findFriendNoticeById(int id) {
        return friendNoticeMapper.findFriendNoticeById(id);
    }
}
