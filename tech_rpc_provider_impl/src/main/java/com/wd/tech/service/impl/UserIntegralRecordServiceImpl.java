package com.wd.tech.service.impl;

import com.wd.tech.dao.UserIntegralMapper;
import com.wd.tech.dao.UserIntegralRecordMapper;
import com.wd.tech.rpc.pojo.UserIntegralRecord;
import com.wd.tech.service.UserIntegralRecordService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户积分明细实现类
 * @author: Lzy
 * @create: 2018-09-03 10:43
 **/
@Service("userIntegralRecordService")
public class UserIntegralRecordServiceImpl implements UserIntegralRecordService {

    @Resource
    private UserIntegralRecordMapper userIntegralRecordMapper;

    @Resource
    private UserIntegralMapper userIntegralMapper;


    @Override
    public List<UserIntegralRecord> findUserIntegralRecord(int userId, int page, int count) {
        return userIntegralRecordMapper.findUserIntegralRecord(userId, CommonUtil.getPageIndex(page, count),count);
    }

    @Override
    public int addUserDetailIntegral(UserIntegralRecord userIntegralRecord) {
        return userIntegralRecordMapper.addUserDetailIntegral(userIntegralRecord);
    }


}
