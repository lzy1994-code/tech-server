package com.wd.tech.service.impl;

import com.wd.tech.dao.ChatRecordMapper;
import com.wd.tech.rpc.pojo.ChatRecord;
import com.wd.tech.rpc.pojo.User;
import com.wd.tech.service.ChatRecordService;
import com.wd.tech.service.UserService;
import com.wd.tech.util.CommonUtil;
import com.wd.tech.util.RsaCoder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xyj on 2018/8/31.
 */
@Service("chatRecordService")
public class ChatRecordServiceImpl implements ChatRecordService {

    private Logger logger = LoggerFactory.getLogger("chatRecordService");

    @Resource
    private ChatRecordMapper chatRecordMapper;

    @Resource
    private UserService userService;

    @Override
    public int saveChatRecord(int sendUid, int receiveUid, String content, String chatImage) {

        try {
            User sendUser = userService.getUserInfoById(sendUid);
            User receiveUser = userService.getUserInfoById(receiveUid);

            //图片消息处理
            String secret = null;
            String imgUrl = null;
            if(null != chatImage && !"".equals(chatImage))
            {
                chatImage = RsaCoder.decryptByPrivateKey(chatImage);
                String [] message = chatImage.split(";");
                if(message.length == 2)
                {
                    imgUrl = message[0];
                    secret = message[1];
                }
            }

            //消息解密
            String decryptContent = RsaCoder.decryptByPrivateKey(content);

            //TODO 客户端直接对接环信实现信息发送，服务端不做环信接口调用
//            ImMessagePushServer.sendUserMessage(receiveUser.getUserName(),decryptContent,sendUser.getUserName(),imgUrl,secret);
            Date chatTime = new Date();

            //对明文消息内容做私钥加密处理
            String encryContent = RsaCoder.encryptByPrivateKey(decryptContent);

            ChatRecord sendRecord = new ChatRecord();
            sendRecord.setUserId(sendUid);
            sendRecord.setFriendId(receiveUid);
            sendRecord.setChatImage(chatImage);
            sendRecord.setChatContent(encryContent);
            sendRecord.setDirection(ChatRecord.DIRECTION_SEND);
            sendRecord.setChatTime(chatTime);
            sendRecord.setHeadPic(sendUser.getHeadPic());

            ChatRecord receiveRecord = new ChatRecord();
            receiveRecord.setUserId(receiveUid);
            receiveRecord.setFriendId(sendUid);
            receiveRecord.setChatImage(chatImage);
            receiveRecord.setChatContent(encryContent);
            receiveRecord.setDirection(ChatRecord.DIRECTION_RECEIVE);
            receiveRecord.setChatTime(chatTime);
            receiveRecord.setHeadPic(sendUser.getHeadPic());

            List<ChatRecord> list = new ArrayList<>();
            list.add(sendRecord);
            list.add(receiveRecord);

            return chatRecordMapper.batchAddChatRecord(list);
        } catch (Exception e) {
            logger.error("saveChatRecord",e);
            return 0;
        }
    }

    @Override
    public ChatRecord findLastRecord(int userId, int friend) {
        return null;
    }

    @Override
    public List<ChatRecord> findChatRecordPageList(int userId, int friend, int page, int count) {
        return chatRecordMapper.findChatRecordPageList(userId, friend, CommonUtil.getPageIndex(page, count), count);
    }

    @Override
    public List<ChatRecord> syncChatHistory(int userId, int friend, int month) {
        DateTime now = new DateTime();
        now = now.minusMonths(1);
        String time = now.toString("yyyy-MM-dd HH:mm:ss");
        return chatRecordMapper.findChatHistory(userId,friend,time);
    }

    @Override
    public int deleteChatRecord(int userId, int friend) {
        return chatRecordMapper.deleteChatRecord(userId, friend);
    }

}
