package com.gpms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.BaseTest;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.User;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

public class TeacherMapperTest extends BaseTest {
    @Autowired
    private com.gpms.dao.mapper.TeacherMapper teacherMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",  1);
        List<Teacher> teacherList = teacherMapper.selectTeacherList();
//        Assert.assertEquals(1, userList.size());
        for (Teacher teacher : teacherList) System.out.println(teacher);
    }
}
