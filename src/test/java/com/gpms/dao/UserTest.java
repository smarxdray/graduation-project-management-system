package com.gpms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

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