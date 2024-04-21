package com.szxy.service;

import com.szxy.eneity.Stuclass;
import com.szxy.service.impl.StuclassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/23 0023.
 * testStuclassServiceImpl
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testStuclassServiceImpl extends AbstractTestNGSpringContextTests {

    @Autowired
    private StuclassService stuclassService;

    @Test
    public void testFindAllStuClass(){
        List<Stuclass> list = stuclassService.findAllStuClass();
        for (Stuclass sc:list) {
            System.out.println(sc.toString());
        }
    }
}
