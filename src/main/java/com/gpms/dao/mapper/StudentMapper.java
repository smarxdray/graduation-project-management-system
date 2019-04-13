package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper extends BaseMapper<StudentDetail> {
    List<Student> selectStudentsAllottedOrNot(@Param("allotted") boolean allotted);
    List<Student> selectStudentsByTeacher(@Param("teacherId") Integer teacherId);
//    int insertStudentDetail(StudentDetail detail);
}