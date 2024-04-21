package com.szxy.mapper;

import com.szxy.eneity.Admin;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 管理员操作
 */
public interface AdminMapper {
    /**
     * 查询管理员
     * 登陆的时候将输入的账户名和密码都传入后台
     * 根据账户名查找管理员表,查询到的话再和传入的密码做匹配是否登陆成功
     * 否则跳转到登陆页面,并且返回错误参数(账户名不存在或者密码错误)到login.jsp做处理
     */
    Admin findAdmin(String admNum);

    /**
     * 更新管理员
     * 用于修改密码
     */
    void updateAdmin(Admin admin);
}
