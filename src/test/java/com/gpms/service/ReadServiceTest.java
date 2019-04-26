package com.gpms.service;

import com.gpms.BaseTest;
import com.gpms.domain.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReadServiceTest extends BaseTest {
    @Autowired
    ReadService readService;

    @Test
    public void getTeachers() {
        List<Teacher> teachers = readService.getTeachers(null, null, 1, null);
        System.out.println(teachers.size());
    }
}
