package com.wd.tech.service.impl;

import com.wd.tech.dao.FocusUserMapper;
import com.wd.tech.dao.UserVipMapper;
import com.wd.tech.rpc.pojo.FocusUser;
import com.wd.tech.rpc.vo.FocusUserVo;
import com.wd.tech.service.FocusUserService;
import com.wd.tech.service.UserVipService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户关注实现类
 * @author: Lzy
 * @create: 2018-09-07 13:49
 **/
@Service("focusUserService")
public class FocusUserServiceImpl implements FocusUserService {

    @Resource
    private FocusUserMapper focusUserMapper;

    @Resource
    private UserVipService userVipService;

    @Override
    public List<FocusUserVo> findFollowUserList(int userId, int page,int count) {
        List<FocusUserVo> followUserList = focusUserMapper.findFollowUserList(userId, CommonUtil.getPageIndex(page, count),count);
        for (FocusUserVo focusUserVo:followUserList) {
            focusUserVo.setWhetherVip(userVipService.whetherVipUser(focusUserVo.getFocusUid()));
            focusUserVo.setWhetherMutualFollow(whetherMutualFollow(userId,focusUserVo.getFocusUid()));
        }
        return followUserList;
    }

    @Override
    public boolean addFollow(int userId, int focusId) {
        return focusUserMapper.addFollow(userId,focusId);
    }

    @Override
    public int whetherFollowUser(int userId, int focusId) {
        int i = focusUserMapper.whetherFollowUser(userId, focusId);
        if (i==1){
            return FocusUser.whetherFollow_YES;
        }
        return FocusUser.whetherFollow_NO;
    }

    @Override
    public boolean cancelFollow(int userId, int focusId) {
        return focusUserMapper.cancelFollow(userId,focusId);
    }

    @Override
    public int whetherMutualFollow(int userId, int focusId) {
        int i = focusUserMapper.whetherMutualFollow(userId, focusId);
        if (i==1){
            return FocusUserVo.whetherMutualFollow_YES;
        }
        return FocusUserVo.whetherMutualFollow_NO;
    }
}
