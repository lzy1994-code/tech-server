package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xyj on 2018/10/11.
 */
public class FriendRelationServiceTest extends BaseTest {

    @Resource
    private FriendRelationService friendRelationService;

    @Test
    public void addFriend() {
    }

    @Test
    public void findUserFriendRelationList() {
    }

    @Test
    public void deleteFriendRelation() {
    }

    @Test
    public void modifyFriendRemark() {
    }

    @Test
    public void modifyFriendGroup() {
    }

    @Test
    public void checkMyFriend() {
    }

    @Test
    public void findFriendGroupId() {
    }

    @Test
    public void batchTransferFriendGroup() {
    }

    @Test
    public void findFriendListByGroupId() {
    }

    @Test
    public void searchFriend() {
        System.out.println(friendRelationService.searchFriend(1020,"s"));
    }
}