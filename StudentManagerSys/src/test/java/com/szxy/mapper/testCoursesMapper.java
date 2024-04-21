package com.szxy.mapper;

import com.szxy.eneity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/15 0015.
 * 科目表操作测试
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testCoursesMapper extends AbstractTestNGSpringContextTests {

    @Autowired
    private CoursesMapper coursesMapper;

    /**
     * 查询所有课程
     */
    @Test
    public void testFindAllCoueses(){
        List<Courses> list = coursesMapper.findAllCoueses();
        for (Courses c:list) {
            System.out.println(c);
        }
    }

    /**
     * 添加课程
     */
    @Test
    public void testInsertCourse(){
        Courses c = new Courses("C)U994","数据结构","30","卢彪");
        coursesMapper.insertCourse(c);
    }

    /**
     * 修改课程信息
     */
    @Test
    public void testUpdateCourses(){
        Courses c = new Courses("COU994","高等数学","30","谈成访");
        coursesMapper.updateCourses(c);
    }

    /**
     *根据课程编号删除课程
     */
    @Test
    public void testDelCourseByCouNum(){
        coursesMapper.delCourseByCouNum("COU994");
    }
}
