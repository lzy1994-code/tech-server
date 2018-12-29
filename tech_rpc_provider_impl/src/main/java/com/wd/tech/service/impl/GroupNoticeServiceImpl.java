package com.wd.tech.service.impl;

import com.wd.tech.dao.GroupNoticeMapper;
import com.wd.tech.rpc.pojo.GroupNotice;
import com.wd.tech.service.GroupMemberService;
import com.wd.tech.service.GroupNoticeService;
import com.wd.tech.util.CommonUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/9/5.
 */
@Service("groupNoticeService")
public class GroupNoticeServiceImpl implements GroupNoticeService {

    private Logger logger = LoggerFactory.getLogger("groupNoticeService");

    @Resource
    private GroupNoticeMapper groupNoticeMapper;

    @Resource
    private GroupMemberService groupMemberService;

    @Override
    public int applyAddGroup(int groupId, int fromUid, String remark) {

        try {
            //判断用户是否已在群里
            if(groupMemberService.whetherInGroup(fromUid,groupId) > 0)
            {
                return 2;
            }

            //生成处理批号
            String batchNumber = getBatchNumber(groupId,fromUid);

            //查询群管理员
            List<Integer> groupManager = groupMemberService.findGroupManager(groupId);
            GroupNotice groupNotice;
            List<GroupNotice> addList = new ArrayList<>();
            for(int managerUid:groupManager)
            {
                groupNotice = new GroupNotice();
                groupNotice.setBatchNumber(batchNumber);
                groupNotice.setGroupId(groupId);
                groupNotice.setFromUid(fromUid);
                groupNotice.setReceiverUid(managerUid);
                groupNotice.setRemark(remark);
                groupNotice.setStatus(GroupNotice.STATUS_DCL);
                groupNotice.setType(GroupNotice.TYPE_SQ);
                groupNotice.setNoticeTime(new Date());
                addList.add(groupNotice);
            }
            groupNoticeMapper.batchAddGroupNotice(addList);
            return 1;
        } catch (Exception e) {
            logger.error("applyAddGroup",e);
            return 0;
        }
    }


    private String getBatchNumber(int groupId, int fromUid)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(DateTime.now().getMillis());
        sb.append(groupId);
        sb.append(fromUid);
        return sb.toString();
    }

    @Override
    public int inviteAddGroup(int groupId, int fromUid, int receiverUid) {

        //判断用户是否已在群里
        if(groupMemberService.whetherInGroup(receiverUid,groupId) > 0)
        {
            return 2;
        }

        GroupNotice groupNotice = new GroupNotice();
        groupNotice.setGroupId(groupId);
        groupNotice.setFromUid(fromUid);
        groupNotice.setReceiverUid(receiverUid);
        groupNotice.setStatus(GroupNotice.STATUS_DCL);
        groupNotice.setType(GroupNotice.TYPE_YQ);
        groupNotice.setNoticeTime(new Date());

        return groupNoticeMapper.addGroupNotice(groupNotice);
    }

    @Override
    public List<GroupNotice> findGroupNoticePageList(int userId, int page, int count) {
        return groupNoticeMapper.findGroupNoticePageList(userId, CommonUtil.getPageIndex(page, count), count);
    }

    @Override
    public int batchPass(String batchNumber) {
        return groupNoticeMapper.updateBatchStatus(batchNumber,GroupNotice.STATUS_TG);
    }

    @Override
    public int batchReject(String batchNumber) {
        return groupNoticeMapper.updateBatchStatus(batchNumber,GroupNotice.STATUS_JJ);
    }

    @Override
    public int pass(int noticeId) {
        return groupNoticeMapper.updateStatus(noticeId,GroupNotice.STATUS_TG);
    }

    @Override
    public int reject(int noticeId) {
        return groupNoticeMapper.updateStatus(noticeId,GroupNotice.STATUS_JJ);
    }

    @Override
    public GroupNotice getGroupNoticeById(int noticeId) {
        return groupNoticeMapper.getGroupNoticeById(noticeId);
    }

    @Override
    public int deleteByGroupId(int groupId) {
        return groupNoticeMapper.deleteByGroupId(groupId);
    }
}
