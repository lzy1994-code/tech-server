package com.wd.tech.service.impl;

import com.wd.tech.dao.CommunityCountMapper;
import com.wd.tech.dao.CommunityGreatMapper;
import com.wd.tech.rpc.pojo.CommunityGreat;
import com.wd.tech.service.CommunityGreatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tech-rpc
 * @description: 社区点赞实现类
 * @author: Lzy
 * @create: 2018-09-07 15:54
 **/
@Service("communityGreatService")
public class CommunityGreatServiceImpl implements CommunityGreatService {

    @Resource
    private CommunityGreatMapper communityGreatMapper;

    @Resource
    private CommunityCountMapper communityCountMapper;
    @Override
    public boolean addCommunityGreat(int userId, int communityId) {
        boolean boo = communityGreatMapper.addCommunityGreat(userId, communityId);
        if (boo){
            communityCountMapper.updateCommunityPraiseNum(1,communityId);
        }
        return boo;
    }

    @Override
    public boolean cancelCommunityGreat(int userId, int communityId) {
        boolean boo = communityGreatMapper.cancelCommunityGreat(userId, communityId);
        if (boo){
            communityCountMapper.updateCommunityPraiseNum(-1,communityId);
        }
        return boo;
    }

    @Override
    public int whetherCommunityGreat(int userId, int communityId) {
        int num = communityGreatMapper.whetherCommunityGreat(userId, communityId);
        if (num==0){
            return CommunityGreat.WHETHER_GREAT_NO;
        }
        return CommunityGreat.WHETHER_GREAT_YES;
    }
}
