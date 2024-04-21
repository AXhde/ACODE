package com.szxy.service.impl;

import com.szxy.eneity.Courses;
import com.szxy.mapper.CoursesMapper;
import com.szxy.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.z on 2018/5/3 0003.
 * CoursesServiceImpl
 */
@Service
@Transactional
public class CoursesServiceImpl implements CoursesService{

    @Autowired
    private CoursesMapper coursesMapper;


    @Override
    public List<Courses> findAllCoueses() {
        return coursesMapper.findAllCoueses();
    }

    @Override
    public Courses findCouesesByCouNum(String couNum) {
        return coursesMapper.findCouesesByCouNum(couNum);
    }

    @Override
    public void insertCourse(Courses courses) {
        coursesMapper.insertCourse(courses);
    }

    @Override
    public void updateCourses(Courses courses) {
        coursesMapper.updateCourses(courses);
    }

    @Override
    public void delCourseByCouNum(String couNum) {
        coursesMapper.delCourseByCouNum(couNum);
    }
}
