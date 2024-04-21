package com.szxy.mapper;

import com.szxy.eneity.Courses;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 课程信息操作
 */
public interface CoursesMapper {

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
