package com.szxy.service;

import com.szxy.eneity.Teacher;

import java.util.List;

/**
 * Created by Mr.z on 2018/5/2 0002.
 * TeacherService
 */
public interface TeacherService {
    /**
     * 查询所有教师 按教师姓名排序
     */
    List<Teacher> findAllTeacher();

    /**
     * 根据教师编号查询教师
     */
    Teacher findTeaByTeaNum(String teaNum);

    /**
     * 添加教师
     */
    void insertTeacher(Teacher teacher);

    /**
     * 根据教师编号删除教师
     */
    void delTeacherByTeaNum(String teaNum);

    /**
     * 根据教师编号修改教师信息
     */
    void updateTeacher(Teacher teacher);
}
