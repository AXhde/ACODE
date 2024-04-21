package com.szxy.controller;

import com.szxy.eneity.Courses;
import com.szxy.eneity.Score;
import com.szxy.eneity.Student;
import com.szxy.eneity.Teacher;
import com.szxy.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.z on 2018/5/5 0005.
 * StudentController
 * 学生模块控制层
 */
@Controller
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private StuclassServiceImpl stuclassService;

    @Autowired
    private ScoreServiceImpl scoreService;

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private CoursesServiceImpl coursesService;

    /**
     * 点击密码修改
     * 加载密码修改界面
     */
    @RequestMapping("/changePswPage.action")
    public ModelAndView loadChangePswPage(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Student> list = studentService.findStudentByStuNum(nowNum);
        Student student = list.get(0);
        session.setAttribute("nowstu",student);
        modelAndView.setViewName("common/changePswPage");
        return  modelAndView;
    }

    /**
     * 保存修改的密码
     */
    @RequestMapping("saveChangePsw.action")
    public ModelAndView saveChangePsw(HttpServletRequest req,String stuNum,String newPsw){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Student> list = studentService.findStudentByStuNum(stuNum);
        Student s = list.get(0);
        s.setStuPsw(newPsw);
        studentService.updateStuByStuNum(s);
        modelAndView.setViewName("common/welcome");
        return modelAndView;
    }

    /**
     * 点击信息维护,加载个人信息页面
     */
    @RequestMapping("/loadMymsgPage.action")
    public ModelAndView loadMymsgPage(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Student> list = studentService.findStudentByStuNum(nowNum);
        Student s = list.get(0);
        session.setAttribute("mymsg",s);
        modelAndView.setViewName("common/mymsgPage");
        return  modelAndView;
    }

    /**
     * 点击保存修改
     * 更新个人信息
     */
    @RequestMapping("/savemsg.action")
    public ModelAndView saveMsg(String stuNum,String stuName,String sex,String stuPhone,String createDate,String stuAddress){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.findStudentByStuNum(stuNum);
        Student s = list.get(0);
        s.setStuName(stuName);
        s.setSex(sex);
        s.setStuPhone(stuPhone);
        s.setCreateDate(createDate);
        s.setStuAddress(stuAddress);
        studentService.updateStuByStuNum(s);
        modelAndView.setViewName("common/welcome");
        return modelAndView;
    }

    /**
     * 点击查看教师
     * 展示所有教师列表
     */
    @RequestMapping("/showtea.action")
    public ModelAndView showTea(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Teacher> list = teacherService.findAllTeacher();
        session.setAttribute("showteacher",list);
        modelAndView.setViewName("common/showTea");
        return modelAndView;
    }

    /**
     * 点击查看课程
     * 展示所有课程列表
     */
    @RequestMapping("/showCourses.action")
    public ModelAndView showCourses(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/showCourses");
        return modelAndView;
    }

    /**
     * 点击查看已选课程
     * 展示所有课程列表
     */
    @RequestMapping("/showScore.action")
    public ModelAndView showScore(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Score> list = scoreService.findScoreByStuNum(nowNum);
        session.setAttribute("allScore",list);
        modelAndView.setViewName("common/showScore");
        return modelAndView;
    }

    /**
     * 点击查看课程
     * 展示所有课程列表
     */
    @RequestMapping("/loadSelectCouPage.action")
    public ModelAndView loadSelectCouPage(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/selectCouPage");
        return modelAndView;
    }

    /**
     * 点击确认选课
     * 展示已勾选的课程页面
     */
    @RequestMapping("/confirmCouPage.action")
    public ModelAndView confirmCouPage(HttpServletRequest req,String selectMsg){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        String[] msg = selectMsg.split(",");
        List<Score> list = new ArrayList<Score>();
        if (msg.length>=1){
            for (int i = 1; i < msg.length; i++) {
                Score sc = new Score();
                sc.setStuNum(msg[0]);
                sc.setCouName(msg[i]);
                list.add(sc);
            }
        }
        session.setAttribute("selectCouList",list);
        modelAndView.setViewName("common/confirmCouPage");
        return modelAndView;
    }

    /**
     * 点击确认选课
     * 添加勾选的课程
     */
    @RequestMapping("/saveSelectScore.action")
    public ModelAndView saveSelectScore(HttpServletRequest req,String scMsg){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        String[] msg = scMsg.split(",");
        System.out.println("==="+msg.length);
        for (int i = 1; i < msg.length; i++) {
            Score sc = new Score();
            sc.setStuNum(msg[0]);
            sc.setCouName(msg[i]);
            System.out.println("==:"+sc.toString());
            scoreService.insertScore(sc);
        }
        List<Score> list = scoreService.findScoreByStuNum(msg[0]);
        session.setAttribute("allScore",list);
        modelAndView.setViewName("common/showScore");
        return modelAndView;
    }
}
