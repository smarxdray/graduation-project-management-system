package com.gpms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gpms.dao.domain.Teacher;
import com.gpms.dao.domain.entity.TeacherDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeacherMapper extends BaseMapper<TeacherDetails> {
    List<Teacher> selectTeacherList();
}
