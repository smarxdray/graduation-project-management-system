package com.gpms.dao;

import com.gpms.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentMapperTest extends BaseTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

//        List<Student> studentList = studentMapper.selectStudentsNotAllotted();
//        for (Student s : studentList) System.out.println(s.getDetail());
    }
}
