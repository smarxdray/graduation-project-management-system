package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.TeacherDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
public interface TeacherMapper extends BaseMapper<TeacherDetail> {
    List<Teacher> selectTeachersByMajor(@Param("majorId") Integer majorId);
    List<Teacher> selectTeachers(@Param("name") String name,
                                 @Param("college") Integer college,
                                 @Param("major") Integer major,
                                 @Param("projectStatus") Integer projectStatus);
    List<Teacher> selectTeachersHavingProjects(@Param("projectStatus") Integer projectStatus);
}
