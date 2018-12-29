package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.Information;
import com.wd.tech.rpc.vo.InformationListVo;
import com.wd.tech.rpc.vo.InformationVagueVo;
import com.wd.tech.rpc.vo.InformationVo;
import com.wd.tech.rpc.vo.RecommendReadVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 资讯dao
 * @author: Lzy
 * @create: 2018-08-28 15:40
 **/
public interface InformationMapper {

    /**
     * 资讯推荐展示列表
     * @param index
     * @param count
     * @return
     */
   List<InformationListVo> infoRecommendList(@Param("index") int index, @Param("count") int count);

    /**
     * 资讯详情展示
     * @param id
     * @return
     */
    InformationVo findInformationDetails(int id);

    /**
     * 收费资讯详情展示
     * @param id
     * @return
     */
    InformationVo findInformationPay(int id);

    /**
     * 通过板块查询所属资讯列表
     * @param plateId
     * @return
     */
    List<InformationListVo> findInformationByPlate(@Param("plateId") int plateId,@Param("index") int index, @Param("count") int count);

    /**
     * 查看详情时下方的推荐阅读
     * @param id
     * @return
     */
    RecommendReadVo recommendReads(int id);

    /**
     * 根据标题模糊查询
     * @param title
     * @return
     */
    List<InformationVagueVo> findInformationByTitle(@Param("title") String title,@Param("index") int index,@Param("count") int count);

 /**
  * 根据来源（作者）模糊查询
  * @param source
  * @param index
  * @param count
  * @return
  */
 List<InformationVagueVo> findInformationBySource(@Param("source") String source,@Param("index") int index,@Param("count") int count);
 /**
  * 是否付费
  * @param id
  * @return
  */
     Information whetherPay(int id);

}
