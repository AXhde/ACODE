package com.szxy.controller;

import com.szxy.eneity.Stuclass;
import com.szxy.service.impl.StuclassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Mr.z on 2018/4/9 0009.
 * 系统初始化/安全退出/加载注册界面
 */
@Controller
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private StuclassServiceImpl stuclassService;

    /**
     * 系统加载,跳转登陆界面
     */
    @RequestMapping("/index.action")
    public ModelAndView queryIndex(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = req.getSession();
        session.invalidate();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logout.action")
    public String Logout(HttpSession session){
        session.invalidate();
        return "login/login";
    }

    /**
     * 跳转到注册界面
     */
    @RequestMapping("register.action")
    public String Register(HttpServletRequest req){
        HttpSession session = req.getSession();
        List<Stuclass> list = stuclassService.findAllStuClass();
        session.setAttribute("classlist",list);
        return "register/register";
    }
}
