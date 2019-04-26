package com.gpms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpms.BaseTest;
import com.gpms.domain.Teacher;
import com.gpms.domain.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherMapperTest extends BaseTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Ignore
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",  1);
        List<Teacher> teacherList = teacherMapper.selectTeachersByMajor(1);
//        Assert.assertEquals(1, userList.size());
        for (Teacher teacher : teacherList) System.out.println(teacher);
    }

    @Ignore
    public void selectTeachersWhoHasProjects(){
        List<Teacher> teachers = teacherMapper.selectTeachersHavingProjects(0);
        System.out.println(teachers.size());
        System.out.println(teachers.get(0).getDetail().getCollege());
    }

    @Test
    public void selectTeachers() {
        List<Teacher> teachers = teacherMapper.selectTeachers("teach", null, null, 0);
        System.out.println(teachers.size());
    }
}
