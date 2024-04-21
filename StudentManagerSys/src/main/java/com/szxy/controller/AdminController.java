package com.szxy.controller;

import com.szxy.eneity.*;
import com.szxy.service.impl.*;
import com.szxy.util.CreateClassNumUtils;
import com.szxy.util.CreateCoursesNumUtils;
import com.szxy.util.CreateStuNumUtils;
import com.szxy.util.CreateTeaNumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Mr.z on 2018/4/17 0009.
 * 管理员模块控制层
 */
@Controller
@RequestMapping("/index")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

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

    /** 登陆后端验证 **/
    @RequestMapping("/login.action")
    public ModelAndView loginIndex(Model model, HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        //获取登陆账号
        String usename = req.getParameter("username");
        //获取登陆密码
        String password = req.getParameter("password");
        System.out.println("username:"+usename+"  password:"+password);
        if (usename.length()==0){
            model.addAttribute("error2","请输入用户名");
            modelAndView.setViewName("login/login");
        }else if (password.length()==0){
            model.addAttribute("error3","请输入密码");
            modelAndView.setViewName("login/login");
        }else{
            //获取单选框状态,flag=1为管理员登陆,flag=null学生登陆
            String flag = req.getParameter("remember");
            if (null!=flag){
                //管理员登陆
                Admin admin = adminService.findAdmin(usename);
                if (null!=admin){
                    if (admin.getAdmPsw().equals(password)){
                        //登陆成功
                        HttpSession session = req.getSession();
                        session.setAttribute("admin",admin);
                        modelAndView.setViewName("admin/adminPage");
                    }else{
                        model.addAttribute("error1","密码错误");
                        modelAndView.setViewName("login/login");
                    }
                }else {
                    model.addAttribute("error0","用户不存在");
                    modelAndView.setViewName("login/login");
                }
            }else{
                //学生登陆
                List<Student> list = studentService.findStudentByStuNum(usename);
                Student student = null;
                if (list.size()!=0){
                    student = list.get(0);
                }
                if (null!=student){
                    if (student.getStuPsw().equals(password)){
                        //登陆成功
                        HttpSession session = req.getSession();
                        session.setAttribute("student",student);
                        modelAndView.setViewName("student/studentPage");
                    }else {
                        model.addAttribute("error1","密码错误");
                        modelAndView.setViewName("login/login");
                    }
                }else {
                    model.addAttribute("error0","用户不存在");
                    modelAndView.setViewName("login/login");
                }
            }
        }
        return modelAndView;
    }

    /**
     * 点击加载回到首页
     */
    @RequestMapping("/index.action")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/welcome");
        return modelAndView;
    }

    /**
     * 学生注册
     */
    @RequestMapping("/register.action")
    public ModelAndView regist(Model model,Student student){
        ModelAndView modelAndView = new ModelAndView();
        //调用工具类,自动生成学号
        student.setStuNum(CreateStuNumUtils.printId());
        //将生成的学号放入作用域,展示到下一个界面
        model.addAttribute("NewStuNum",student.getStuNum());
        //保存学生数据到数据库
        studentService.regStudent(student);
        modelAndView.setViewName("register/regok");
        return modelAndView;
    }

    /**
     * 点击密码修改
     * 加载密码修改界面
     */
    @RequestMapping("/changeAdmPswPage.action")
    public ModelAndView loadChangePswPage(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Admin admin = adminService.findAdmin(nowNum);
        session.setAttribute("nowAdm",admin);
        modelAndView.setViewName("common/changeAdmPswPage");
        return  modelAndView;
    }

    /**
     * 保存修改的密码
     */
    @RequestMapping("saveChangeAdmPsw.action")
    public ModelAndView saveChangeAdmPsw(HttpServletRequest req,String admNum,String newPsw){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Admin a = adminService.findAdmin(admNum);
        a.setAdmPsw(newPsw);
        adminService.updateAdmin(a);
        modelAndView.setViewName("common/welcome");
        return modelAndView;
    }

    /**
     * 点击加载关于我们
     */
    @RequestMapping("/about.action")
    public ModelAndView about(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/about");
        return modelAndView;
    }

    /**
     * 点击查看学生
     * 并加载第一页学生信息
     */
    @RequestMapping("/stulist.action")
    public ModelAndView findStu(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //将现有班级列表放入作用域
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("classlist",list);
        //分页查询所有学生 第一页
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,null,null,null,null);
        //System.out.println("==++=="+stuPage.toString());
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/studentList");
        return modelAndView;
    }

    /**
     * 点击翻页
     */
    @RequestMapping("/runPage.action")
    public ModelAndView Page(HttpServletRequest req,Integer pagenow,String stuNum,String stuName,String clsName,String createDate){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        if (stuNum==""){
            stuNum=null;
        }
        if (stuName==""){
            stuName=null;
        }
        if (clsName.equals("-1")){
            clsName=null;
        }
        if (createDate==""){
            createDate=null;
        }
        PageBean<Student> stuPage = studentService.findStudentByPage(pagenow,8,stuNum,stuName,clsName,createDate);
        //System.out.println("==++=="+stuPage.toString());
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/stutable");
        return modelAndView;
    }

    /**
     * 点击查询
     */
    @RequestMapping("/chaxun.action")
    public ModelAndView chaxun(HttpServletRequest req,String stuNum,String stuName,String clsName,String createDate){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        if (stuNum==""){
            stuNum=null;
        }
        if (stuName==""){
            stuName=null;
        }
        if (clsName.equals("-1")){
            clsName=null;
        }
        if (createDate==""){
            createDate=null;
        }
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,stuNum,stuName,clsName,createDate);
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/stutable");
        return modelAndView;
    }

    /**
     * 点击删除图标,删除当前行学生
     */
    @RequestMapping("/delStuByNum.action")
    public ModelAndView delStuByNum(HttpServletRequest req,String delNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //根据stuNum删除学生
        studentService.delStudentByStuNum(delNum);
        //同时删除该学生所有选课成绩
        scoreService.delAllScoreByStuNum(delNum);
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,null,null,null,null);
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/studentList");
        return modelAndView;
    }

    /**
     * 点击查看(放大镜图标)
     * 获取当前学生详细信息以及选课信息到详情页
     */
    @RequestMapping("seeOneStu.action")
    public ModelAndView seeOnestu(HttpServletRequest req,String Num) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //System.out.println("findStuByStuNum:"+studentService.findStudentByStuNum(Num));
        List<Student> nowStulist = studentService.findStudentByStuNum(Num);
        Student nowStu = nowStulist.get(0);
        session.setAttribute("nowStu",nowStu);
        List<Score> sclist = scoreService.findScoreByStuNum(Num);
        session.setAttribute("sclist",sclist);
        modelAndView.setViewName("common/seestudent");
        return modelAndView;
    }

    /**
     * 点击(seestudent.jsp)保存修改
     * 保存修改学生信息
     */
    @RequestMapping("/baocun.action")
    public ModelAndView baocun(HttpServletRequest req,String stuNum,String stuName,String stuPsw,String Sex,String stuPhone,String stuAddress,String stuElse) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Student> list = studentService.findStudentByStuNum(stuNum);
        Student s = list.get(0);
        s.setStuNum(stuNum);
        s.setStuName(stuName);
        s.setStuPsw(stuPsw);
        s.setSex(Sex);
        s.setStuPhone(stuPhone);
        s.setStuAddress(stuAddress);
        s.setStuElse(stuElse);
        //调用方法保存修改
        studentService.updateStuByStuNum(s);
        //分页查询所有学生 第一页
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,null,null,null,null);
        //System.out.println("==++=="+stuPage.toString());
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/studentList");
        return modelAndView;
    }

    /**
     * 点击(seestudent.jsp)保存修改
     * 保存学生课程成绩
     */
    @RequestMapping("baocunsco.action")
    public ModelAndView baocun(HttpServletRequest req,String coumsg) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        String[] scmsg = coumsg.split(",");
        if (scmsg.length>2){
            for (int i = 1; i <scmsg.length ; i=i+2) {
                Score s = new Score();
                s.setStuNum(scmsg[0]);
                s.setCouName(scmsg[i]);
                s.setScScore(scmsg[i+1]);
                scoreService.updateScoreByStuNumCouName(s);
            }
        }
        //分页查询所有学生 第一页
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,null,null,null,null);
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/studentList");
        return modelAndView;
    }

    /**
     * 加载添加学生的页面
     */
    @RequestMapping("/adds.action")
    public ModelAndView addStu(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //将现有班级列表放入作用域
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("classlist",list);
        modelAndView.setViewName("common/addstu");
        return modelAndView;
    }

    /**
     * 添加学生
     */
    @RequestMapping("/addstu.action")
    public ModelAndView addStudent(HttpServletRequest req,String stuName,String stuPsw,String clsName,String sex,String stuPhone,String createDate,String stuAddress,String stuElse){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Student s = new Student();
        s.setStuNum(CreateStuNumUtils.printId());
        s.setStuName(stuName);
        s.setStuPsw(stuPsw);
        s.setClsName(clsName);
        s.setSex(sex);
        s.setStuPhone(stuPhone);
        s.setCreateDate(createDate);
        s.setStuAddress(stuAddress);
        s.setStuElse(stuElse);
        studentService.regStudent(s);
        //分页查询所有学生 第一页
        PageBean<Student> stuPage = studentService.findStudentByPage(1,8,null,null,null,null);
        session.setAttribute("stuPage",stuPage);
        modelAndView.setViewName("common/studentList");
        return modelAndView;
    }

    /**
     * 点击查看教师
     * 展示所有教师列表
     */
    @RequestMapping("/alltea.action")
    public ModelAndView allTeacher(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Teacher> list = teacherService.findAllTeacher();
        session.setAttribute("teacherlist",list);
        modelAndView.setViewName("common/allteacher");
        return modelAndView;
    }

    /**
     * 点击删除教师
     */
    @RequestMapping("/delteacher.action")
    public  ModelAndView delTeacher(HttpServletRequest req,String delNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //调用Service删除操作
        teacherService.delTeacherByTeaNum(delNum);
        //返回所有教师页面
        List<Teacher> list = teacherService.findAllTeacher();
        session.setAttribute("teacherlist",list);
        modelAndView.setViewName("common/allteacher");
        return modelAndView;
    }

    /**
     * 点击编辑教师按钮
     */
    @RequestMapping("/editortea.action")
    public ModelAndView editorTea(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Teacher t = teacherService.findTeaByTeaNum(nowNum);
        session.setAttribute("nowteaeacher",t);
        modelAndView.setViewName("common/editorteacher");
        return modelAndView;
    }

    /**
     * 点击保存需修改
     * 更新当前教师信息
     */
    @RequestMapping("/savetea.action")
    public ModelAndView saveTea(HttpServletRequest req,String teaNum,String teaName,String teaPhone){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Teacher t = new Teacher();
        t.setTeaNum(teaNum);
        t.setTeaName(teaName);
        t.setTeaPhone(teaPhone);
        teacherService.updateTeacher(t);
        List<Teacher> list = teacherService.findAllTeacher();
        session.setAttribute("teacherlist",list);
        modelAndView.setViewName("common/allteacher");
        return modelAndView;
    }

    /**
     * 加载添加教师的页面
     */
    @RequestMapping("/loadregtpage.action")
    public String loadRegStuPage(){
        return "common/regteacher";
    }

    /**
     * 点击添加教师
     */
    @RequestMapping("/regtea.action")
    public ModelAndView regTeacher(HttpServletRequest req,String teaName,String teaPhone){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //调用Service保存一条教师信息
        Teacher t = new Teacher();
        t.setTeaNum(CreateTeaNumUtils.printId());
        t.setTeaName(teaName);
        t.setTeaPhone(teaPhone);
        teacherService.insertTeacher(t);
        List<Teacher> list = teacherService.findAllTeacher();
        session.setAttribute("teacherlist",list);
        modelAndView.setViewName("common/allteacher");
        return modelAndView;
    }

    /**
     * 点击查询班级
     * 展示所有教师列表
     */
    @RequestMapping("/allcla.action")
    public ModelAndView allClass(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("allclass",list);
        modelAndView.setViewName("common/allclass");
        return modelAndView;
    }

    /**
     * 点击删除班级
     */
    @RequestMapping("/delclass.action")
    public  ModelAndView delclass(HttpServletRequest req,String delNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        stuclassService.delClassByClsNum(delNum);
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("allclass",list);
        modelAndView.setViewName("common/allclass");
        return modelAndView;
    }

    /**
     * 点击编辑班级按钮
     */
    @RequestMapping("/editorclass.action")
    public ModelAndView editorClass(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        //将当前班级信息放入作用域
        Stuclass cl = stuclassService.findClassByClsNum(nowNum);
        session.setAttribute("nowclass",cl);
        //将所有教师信息放入作用域
        List<Teacher> allt = teacherService.findAllTeacher();
        session.setAttribute("allt",allt);
        modelAndView.setViewName("common/editorclass");
        return modelAndView;
    }

    /**
     * 点击保存
     * 更新当前班级信息
     */
    @RequestMapping("/saveclass.action")
    public ModelAndView saveTea(HttpServletRequest req,String clsNum,String clsName,String teaName,String department){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Stuclass sc = new Stuclass();
        sc.setClsNum(clsNum);
        sc.setClsName(clsName);
        sc.setTeaName(teaName);
        sc.setDepartment(department);
        //调用Service持久化更新
        stuclassService.updateClassByClsNum(sc);
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("allclass",list);
        modelAndView.setViewName("common/allclass");
        return modelAndView;
    }

    /**
     * 加载添加教师的页面
     */
    @RequestMapping("/loadAddClassPage.action")
    public String loadAddClassPage(HttpServletRequest req){
        HttpSession session = req.getSession();
        //将所有教师信息放入作用域
        List<Teacher> allt = teacherService.findAllTeacher();
        session.setAttribute("allt",allt);
        return "common/addclasspage";
    }

    /**
     * 点击添加一个班级
     */
    @RequestMapping("/addclass.action")
    public ModelAndView addClass(HttpServletRequest req,String clsName,String teaName,String department){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Stuclass sc = new Stuclass();
        sc.setClsNum(CreateClassNumUtils.printId());
        sc.setClsName(clsName);
        sc.setTeaName(teaName);
        sc.setDepartment(department);
        //调用Service持久化添加的班级数据
        stuclassService.insertClass(sc);
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("allclass",list);
        modelAndView.setViewName("common/allclass");
        return modelAndView;
    }

    /**
     * 点击查看课程
     * 展示所有课程列表
     */
    @RequestMapping("/allcou.action")
    public ModelAndView allcou(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/allcourses");
        return modelAndView;
    }

    /**
     * 点击删除课程
     */
    @RequestMapping("/delcourses.action")
    public  ModelAndView delCourses(HttpServletRequest req,String delNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        coursesService.delCourseByCouNum(delNum);
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/allcourses");
        return modelAndView;
    }

    /**
     * 点击编辑课程按钮
     */
    @RequestMapping("/editorcourses.action")
    public ModelAndView editorCourses(HttpServletRequest req,String nowNum){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Courses c = coursesService.findCouesesByCouNum(nowNum);
        session.setAttribute("nowCourses",c);
        //将所有教师信息放入作用域
        List<Teacher> allt = teacherService.findAllTeacher();
        session.setAttribute("allt",allt);
        modelAndView.setViewName("common/editorcourses");
        return modelAndView;
    }

    /**
     * 点击保存修改
     * 更新当前课程信息
     */
    @RequestMapping("/savecourses.action")
    public ModelAndView saveCourses(HttpServletRequest req,String couNum,String couName,String couhour,String teaName){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Courses c = new Courses();
        c.setCouNum(couNum);
        c.setCouName(couName);
        c.setCouhour(couhour);
        c.setTeaName(teaName);
        coursesService.updateCourses(c);
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/allcourses");
        return modelAndView;
    }

    /**
     * 加载添加课程的页面
     */
    @RequestMapping("/loadAddCourses.action")
    public String loadAddCourses(HttpServletRequest req){
        HttpSession session = req.getSession();
        //将所有教师信息放入作用域
        List<Teacher> allt = teacherService.findAllTeacher();
        session.setAttribute("allt",allt);
        return "common/addcoursespage";
    }

    /**
     * 点击添加课程
     * 成功后返回主页面
     */
    @RequestMapping("/addcoueses.action")
    public ModelAndView addCoueses(HttpServletRequest req,String couName,String couhour,String teaName){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        Courses c = new Courses();
        c.setCouNum(CreateCoursesNumUtils.printId());
        c.setCouName(couName);
        c.setCouhour(couhour);
        c.setTeaName(teaName);
        coursesService.insertCourse(c);
        List<Courses> list = coursesService.findAllCoueses();
        session.setAttribute("allcou",list);
        modelAndView.setViewName("common/allcourses");
        return modelAndView;
    }
}
