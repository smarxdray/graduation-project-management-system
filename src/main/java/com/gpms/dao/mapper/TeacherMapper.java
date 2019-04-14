package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.TeacherDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherMapper extends BaseMapper<TeacherDetail> {
    List<Teacher> selectTeachersByMajor(@Param("majorId") Integer majorId);
    List<Teacher> selectTeacherList();
}
