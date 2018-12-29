package com.wd.tech.service;

import com.wd.tech.rpc.pojo.Information;
import com.wd.tech.rpc.vo.InformationListVo;
import com.wd.tech.rpc.vo.InformationVagueVo;
import com.wd.tech.rpc.vo.InformationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯service
 * @author: Lzy
 * @create: 2018-08-28 17:56
 **/
public interface InformationService {
    /**
     * 资讯推荐展示列表(包含按板块查询)
     * @param page
     * @param count
     * @return
     */
    public List<InformationListVo> infoRecommendList(int userId,int plateId,int page, int count);

    /**
     * 资讯详情展示
     * @param userId
     * @param id
     * @return
     */
    InformationVo findInformationDetails(int userId,int id);
    /**
     * 根据标题模糊查询
     * @param title
     * @param page
     * @param count
     * @return
     */
    List<InformationVagueVo> findInformationByTitle(String title,int page,int count);
    /**
     * 是否付费
     * @param id
     * @return
     */
    int whetherPay(int id);

    /**
     * 根据来源（作者）模糊查询
     * @param source
     * @param page
     * @param count
     * @return
     */
    List<InformationVagueVo> findInformationBySource( String source, int page,int count);
}
