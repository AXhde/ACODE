package com.szxy.service;

import com.szxy.eneity.Courses;

import java.util.List;

/**
 * Created by Mr.z on 2018/5/3 0003.
 * CoursesService
 */
public interface CoursesService {

    /**
     * 查询所有课程
     */
    List<Courses> findAllCoueses();

    /**
     * 根据couNum查询课程
     */
    Courses findCouesesByCouNum(String couNum);

    /**
     * 添加课程
     */
    void insertCourse(Courses courses);

    /**
     * 修改课程信息
     */
    void updateCourses(Courses courses);

    /**
     *根据课程编号删除课程
     */
    void delCourseByCouNum(String couNum);
}
