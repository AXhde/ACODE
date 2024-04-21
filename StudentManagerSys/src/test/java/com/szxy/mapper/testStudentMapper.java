package com.szxy.mapper;

import com.szxy.eneity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/16 0016.
 * 学生操作测试
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testStudentMapper extends AbstractTestNGSpringContextTests{

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学生注册
     */
    @Test
    public void testRegStudent(){
        Student s = new Student("S20149999","刘辉","jsd1707","计算机科学与技术","女","10086","2018-04-15","苏州","备注");
        studentMapper.regStudent(s);
    }

    /**
     * 根据学号查询学生信息
     */
    @Test
    public void testFindStudentByStuNum(){
        List<Student> list = studentMapper.findStudentByStuNum("S9989");
        for (Student s:list) {
            System.out.println(s);
        }
    }

    /**
     * 根据姓名查询学生
     * 有可能存在同姓名的学生,所以返回结果为集合类型
     */
    @Test
    public void testFindStudentByStuName(){
        List<Student> list = studentMapper.findStudentByStuName("陈丽");
        for (Student s:list) {
            System.out.println(s);
        }
    }

    /**
     * 根据学号删除学生
     */
    @Test
    public void testDelStudentByStuNum(){
        studentMapper.delStudentByStuNum("S9993");
    }

    /**
     * 根据姓名,学号,班级名称,入学年份(四位数年份),分页模糊查询学生
     * 首次进入此页,默认班级名和入学年份为null
     * 此时为查询所有学生信息
     * pageNow 查询的当前页
     * pageSize 每页显示条目
     * stuNum 学号
     * stuName 姓名
     * clsName 班级名
     * createDate 入学时间
     */
    @Test
    public void testFindStudentByPage(){
        //其它参数为空,查询所有
        //List<Student> list = studentMapper.findStudentByPage(1,4,null,null,null,null);
        //List<Student> list = studentMapper.findStudentByPage(2,4,null,null,null,null);
        //只按学号查询
        //List<Student> list = studentMapper.findStudentByPage(1,4,"S9998",null,null,null);
        //只按姓名查询
        //List<Student> list = studentMapper.findStudentByPage(1,4,null,"刘辉",null,null);
        //只按b班级名查询
        //List<Student> list = studentMapper.findStudentByPage(1,4,null,null,"计科1",null);
        //只按入学时间查询
        //List<Student> list = studentMapper.findStudentByPage(1,4,null,null,null,"2018-04-16");
        //List<Student> list = studentMapper.findStudentByPage(2,4,null,null,null,"2018-04-15");
        //满条件查询
        List<Student> list = studentMapper.findStudentByPage(1,4,"S9990","陈丽","软工1","2018-04-15");
        for (Student s:list) {
            System.out.println(s);
        }
    }
}
