package com.gpms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.BaseTest;
import com.gpms.domain.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",  1);
        List<User> userList = userMapper.selectList(queryWrapper);
//        Assert.assertEquals(1, userList.size());
        for (User user : userList) System.out.println(user);
    }

}