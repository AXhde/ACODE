package com.szxy.service.impl;

import com.szxy.eneity.Teacher;
import com.szxy.mapper.TeacherMapper;
import com.szxy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.z on 2018/5/2 0002.
 * TeacherServiceImpl
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public Teacher findTeaByTeaNum(String teaNum) {
        return teacherMapper.findTeaByTeaNum(teaNum);
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    @Override
    public void delTeacherByTeaNum(String teaNum) {
        teacherMapper.delTeacherByTeaNum(teaNum);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }
}
