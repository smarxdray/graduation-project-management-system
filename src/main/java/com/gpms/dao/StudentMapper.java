package com.gpms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.domain.Student;
import com.gpms.domain.entity.StudentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper extends BaseMapper<StudentDetail> {
    List<Student> selectStudentsAllottedOrNot(@Param("allotted") boolean allotted);
    List<Student> selectStudentsByTeacher(@Param("teacherId") Integer teacherId);
//    int insertStudentDetail(StudentDetail detail);
}