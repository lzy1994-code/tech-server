package com.wd.tech.rpc.api;

import com.wd.tech.rpc.pojo.Banners;
import com.wd.tech.rpc.pojo.InfoAdvertising;
import com.wd.tech.rpc.pojo.InfoComment;
import com.wd.tech.rpc.pojo.InformationPlate;
import com.wd.tech.rpc.vo.*;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯rpc
 * @author: Lzy
 * @create: 2018-08-29 14:53
 **/
public interface InformationRpcService {

    /**
     * banner展示列表
     */
    List<BannersVo> bannerShow();

    /**
     * 资讯推荐展示列表(包含单独板块列表展示)
     * @param userId
     * @param plateId
     * @param page
     * @param count
     * @return
     */
    List<InformationListVo> infoRecommendList(int userId, int plateId, int page, int count);
    /**
     * 资讯详情展示
     * @param userId
     * @param id
     * @return
     */
    InformationVo findInformationDetails(int userId, int id);

    /**
     * 所有板块查询
     * @return
     */
    List<InformationPlate> findAllInfoPlate();

    /**
     * 修改资讯分享数
     * @param infoId
     */
    boolean updateInfoShareNum(int infoId);
    /**
     * 添加点赞记录
     * @param userId
     * @param infoId
     * @return
     */
    public boolean addGreatRecord(int userId, int infoId);

    /**
     * 取消点赞
     * @param userId
     * @param infoId
     * @return
     */
    boolean cancelGreat(int userId, int infoId);

    /**
     * 用户评论
     * @param infoComment
     * @return
     */
    public boolean addInfoComment(InfoComment infoComment);

    /**
     * 查询资讯评论列表
     * @param infoId
     * @return
     */
    public List<InfoCommentVo> findAllInfoComment(int infoId, int page, int count);
    /**
     * 广告
     * @return
     */
    InfoAdvertisingVo findInfoAdvertising();

    /**
     * 根据标题模糊查询
     * @param title
     * @param page
     * @param count
     * @return
     */
    List<InformationVagueVo> findInformationByTitle(String title, int page, int count);
    /**
     * 根据来源（作者）模糊查询
     * @param source
     * @param page
     * @param count
     * @return
     */
    List<InformationVagueVo> findInformationBySource( String source,int page,int count);
}
