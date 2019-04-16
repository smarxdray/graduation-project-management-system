package com.gpms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.dao.domain.entity.TeacherDetail;
import com.gpms.dao.mapper.StudentMapper;
import com.gpms.dao.mapper.TeacherMapper;
import com.gpms.service.AssignmentService;
import com.gpms.service.StudentService;
import com.gpms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    @Transactional
    public int setAssignments(List<StudentDetail> assigned, List<StudentDetail> unassigned) {
        int lines = 0;
        if (assigned != null && assigned.size() != 0) {
            for (StudentDetail detail: assigned) {
                int ln = studentMapper.updateById(detail);
                if (ln <= 0) studentMapper.insert(detail);
                lines++;
            }
            Integer teacherId = assigned.get(0).getTeacher();
            TeacherDetail teacherDetail = new TeacherDetail();
            teacherDetail.setStudentNumber(lines);
            UpdateWrapper<TeacherDetail> wrapper = new UpdateWrapper<>();
            wrapper.eq("owner", teacherId);
            teacherMapper.update(teacherDetail, wrapper);
        }

        if (unassigned != null && unassigned.size() != 0) {
            for (StudentDetail detail: unassigned) {
                UpdateWrapper<StudentDetail> w = new UpdateWrapper<>();
                w.eq("id", detail.getId());
                w.set("teacher", null);
                studentMapper.update(detail, w);
            }
        }
        return lines;
    }
}
