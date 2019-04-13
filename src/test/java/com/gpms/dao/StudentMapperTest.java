package com.gpms.dao;

import com.gpms.BaseTest;
import com.gpms.dao.domain.Student;
import com.gpms.dao.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
