package com.wd.tech.service;

import com.wd.base.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@Ignore
public class GroupServiceTest extends BaseTest {

    @Resource
    private GroupService groupService;

    @Test
    public void createGroup() {
        int group = groupService.createGroup("测试群", "来玩", 1078, 10);
        System.out.println(group);
    }

    @Test
    public void modifyGroupName() {
    }

    @Test
    public void modifyGroupDescription() {
    }

    @Test
    public void modifyGroupUserNumber() {
    }

    @Test
    public void disbandGroup() {
    }

    @Test
    public void findGroupsByUserId() {
    }

    @Test
    public void findUserJoinedGroup() {
    }

    @Test
    public void getGroupById() {
    }

    @Test
    public void getGroupCurrentCount() {
    }

    @Test
    public void modifyImage() {
    }
}