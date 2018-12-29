package com.wd.tech.service.impl;

import com.wd.tech.dao.InformationCountMapper;
import com.wd.tech.dao.UserInfoCollectionMapper;
import com.wd.tech.rpc.pojo.UserInfoCollection;
import com.wd.tech.service.UserInfoCollectionService;
import com.wd.tech.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户收藏实现类
 * @author: Lzy
 * @create: 2018-09-01 08:05
 **/
@Service("userInfoCollectionService")
public class UserInfoCollectionServiceImpl implements UserInfoCollectionService {

    @Resource
    private UserInfoCollectionMapper userInfoCollectionMapper;

    @Resource
    private InformationCountMapper informationCountMapper;

    @Override
    public List<UserInfoCollection> findAllInfoCollection(int userId, int page, int count) {
        return userInfoCollectionMapper.findAllInfoCollection(userId, CommonUtil.getPageIndex(page,count),count);
    }

    @Override
    public boolean addCollection(int userId, int infoId) {
        boolean boo = userInfoCollectionMapper.addCollection(userId, infoId);
        if (boo){
            informationCountMapper.updateInfoCollectionNum(1,infoId);
        }
        return boo;
    }

    @Override
    public boolean cancelCollection(int userId, List<Integer> infoIds) {
        boolean b = userInfoCollectionMapper.cancelCollection(userId, infoIds);
        if (b){
            for (int infoId:infoIds) {
                informationCountMapper.updateInfoCollectionNum(-1,infoId);
            }
        }
        return b;
    }

    @Override
    public int whetherCollection(int userId, int infoId) {
        int num = userInfoCollectionMapper.whetherCollection(userId, infoId);
        if (num==0){
            return UserInfoCollection.WHETHER_COLLECTION_NO;
        }
        return UserInfoCollection.WHETHER_COLLECTION_YES;
    }
}
