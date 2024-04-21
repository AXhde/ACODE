package com.szxy.mapper;

import com.szxy.eneity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/16 0016.
 * 教师操作测试
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testTeacherMapper extends AbstractTestNGSpringContextTests{

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 查询所有教师 按教师姓名排序
     */
    @Test
    public void testFindAllTeacher(){
        List<Teacher> list = teacherMapper.findAllTeacher();
        for (Teacher t:list) {
            System.out.println(t);
        }
    }

    /**
     * 添加教师
     */
    @Test
    public void testInsertTeacher(){
        Teacher t = new Teacher("T996","白老师","118114");
        teacherMapper.insertTeacher(t);
    }

    /**
     * 根据教师编号删除教师
     */
    @Test
    public void testDelTeacherByTeaNum(){
        teacherMapper.delTeacherByTeaNum("T996");
    }

    /**
     * 根据教师编号修改教师信息
     */
    @Test
    public void testUpdateTeacher(){
        Teacher t = new Teacher("T999","张老师Test","1234567890");
        teacherMapper.updateTeacher(t);
    }
}
