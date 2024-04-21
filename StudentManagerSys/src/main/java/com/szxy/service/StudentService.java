package com.szxy.service;

import com.szxy.eneity.PageBean;
import com.szxy.eneity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/17 0017.
 * StudentService
 */
public interface StudentService {

    /**
     * 学生注册
     */
    void regStudent(Student student);

    /**
     * 根据学号修改学生信息
     */
    void updateStuByStuNum(Student student);

    /**
     * 根据学号查询学生信息
     * 登陆使用
     */
    List<Student> findStudentByStuNum(String stuNum);

    /**
     * 根据姓名查询学生
     * 有可能存在同姓名的学生,所以返回结果为集合类型
     * 教师精准查询使用
     */
    List<Student> findStudentByStuName(String stuName);

    /**
     * 根据学号删除学生
     */
    void delStudentByStuNum(String stuNum);

    /**
     * 根据姓名,学号,班级名称,入学年份(四位数年份),分页模糊查询学生
     * 首次进入此页,默认班级名和入学年份为null
     * 此时为查询所有学生信息
     * @param pageNow 查询的当前页
     * @param pageSize 每页显示条目
     * @param stuNum 学号
     * @param stuName 姓名
     * @param clsName 班级名
     * @param createDate 入学时间
     * @return 数据集合
     */
    PageBean<Student> findStudentByPage(Integer pageNow , Integer pageSize,
                                        String stuNum, String stuName,
                                        String clsName, String createDate);

}
