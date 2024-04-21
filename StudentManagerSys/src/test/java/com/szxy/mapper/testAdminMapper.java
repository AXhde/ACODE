package com.szxy.mapper;

import com.szxy.eneity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by Mr.z on 2018/4/15 0015.
 * AdminMapper单元测试
 */

@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testAdminMapper extends AbstractTestNGSpringContextTests{

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testFindAdmin(){
        Admin admin = adminMapper.findAdmin("A0001");
        System.out.println(admin);
    }
}
