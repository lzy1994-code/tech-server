package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xyj on 2018/9/18.
 */
@Ignore
public class ChatRecordServiceTest extends BaseTest {

    @Resource
    private ChatRecordService chatRecordService;

    @Test
    public void saveChatRecord() {
        chatRecordService.saveChatRecord(1006,1005,"iKI4VlsAlBje5a083ac2yjGE+4Zq26E5dUU+0pBw395q/hUecNjg6eTl1gUVgIFdj7D3Cr83agB4N6hoG/7RxiMPbql9eBXtv4l1+yZkp3r/sVy7rxI7EvGQCVWBWnQujbTnnLkFHYau0BoAKw0omdGHfssXon8/AMGSHexq6CA=",null);
    }

    @Test
    public void findLastRecord() {
    }

    @Test
    public void findChatRecordPageList() {
    }

    @Test
    public void syncChatHistory() {
    }

    @Test
    public void deleteChatRecord() {
    }
}