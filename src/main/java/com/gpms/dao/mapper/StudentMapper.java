package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.Student;
import com.gpms.dao.domain.entity.StudentDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper extends BaseMapper<StudentDetails> {
    List<Student> selectStudentsNotAllotted();
    List<Student> selectStudentListByTeacherId(@Param("id") Integer id);
}