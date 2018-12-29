package com.wd.tech.dao;

import com.wd.tech.rpc.pojo.InfoPayRecord;
import com.wd.tech.rpc.vo.InfoPayRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tech-rpc
 * @description: 用户支付资讯
 * @author: Lzy
 * @create: 2018-09-04 13:55
 **/
public interface InfoPayRecordMapper {

   List<InfoPayRecordVo> findUserPayList(@Param("userId")int userId, @Param("index") int index, @Param("count") int count);

   int whetherUserPay(@Param("userId") int userId,@Param("id") int id);

   int infoPayTotal(int infoId);

   int userPayTotal(int userId);

}
