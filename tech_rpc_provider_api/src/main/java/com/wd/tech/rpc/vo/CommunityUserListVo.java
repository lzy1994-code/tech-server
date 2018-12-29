package com.wd.tech.rpc.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tech-rpc
 * @description: 社区用户帖子页列表
 * @author: Lzy
 * @create: 2018-10-22 16:27
 **/
public class CommunityUserListVo implements Serializable{

      private CommunityUserVo communityUserVo;

      private List<CommunityUserPostVo> communityUserPostVoList;

    public CommunityUserVo getCommunityUserVo() {
        return communityUserVo;
    }

    public void setCommunityUserVo(CommunityUserVo communityUserVo) {
        this.communityUserVo = communityUserVo;
    }

    public List<CommunityUserPostVo> getCommunityUserPostVoList() {
        return communityUserPostVoList;
    }

    public void setCommunityUserPostVoList(List<CommunityUserPostVo> communityUserPostVoList) {
        this.communityUserPostVoList = communityUserPostVoList;
    }

    @Override
    public String toString() {
        return "CommunityUserListVo{" +
                "communityUserVo=" + communityUserVo +
                ", communityUserPostVoList=" + communityUserPostVoList +
                '}';
    }
}
