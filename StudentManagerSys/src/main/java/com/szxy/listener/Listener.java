package com.szxy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 处理上下文路径
 */
@WebListener
public class Listener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        //System.err.println("====="+sc.getContextPath());
        sc.setAttribute("path",sc.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
