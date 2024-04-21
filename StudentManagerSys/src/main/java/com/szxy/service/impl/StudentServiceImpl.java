package com.szxy.service.impl;

import com.szxy.eneity.PageBean;
import com.szxy.eneity.Student;
import com.szxy.mapper.StudentMapper;
import com.szxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/17 0017.
 * StudentServiceImpl
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void regStudent(Student student) {
        studentMapper.regStudent(student);
    }

    @Override
    public void updateStuByStuNum(Student student) {
        studentMapper.updateStuByStuNum(student);
    }

    @Override
    public List<Student> findStudentByStuNum(String stuNum) {
        List<Student> list = studentMapper.findStudentByStuNum(stuNum);
        return list;
    }

    @Override
    public List<Student> findStudentByStuName(String stuName) {
        List<Student> list = studentMapper.findStudentByStuNum(stuName);
        return list;
    }

    @Override
    public void delStudentByStuNum(String stuNum) {
        studentMapper.delStudentByStuNum(stuNum);
    }

    @Override
    public PageBean<Student> findStudentByPage(Integer pageNow, Integer pageSize, String stuNum, String stuName, String clsName, String createDate) {
        PageBean<Student> pageBean = new PageBean<Student>();
        //查询学生数目
        int countRows = studentMapper.countStudent();
        //每页显示8条
        pageSize = 8;

        //总页数处理
        int pageCount = countRows/8;
        if (countRows%8!=0){
            pageCount++;
        }

        //对当前页做处理
        if(pageNow<=1){
            pageNow=1;
        }else if(pageNow>pageCount){
            pageNow=pageCount;
        }

        List<Student> list = studentMapper.findStudentByPage(pageNow,pageSize,stuNum,stuName,clsName,createDate);
        pageBean.setPageNow(pageNow);
        pageBean.setPageSize(pageSize);
        pageBean.setPageCount(pageCount);
        pageBean.setRows(countRows);
        pageBean.setList(list);
        return pageBean;
    }
}
