package com.szxy.mapper;

import com.szxy.eneity.Stuclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/16 0016.
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testStuclassMapper extends AbstractTestNGSpringContextTests{

    @Autowired
    private StuclassMapper stuclassMapper;

    /**
     * 查询所有班级
     */
    @Test
    public void testFindAllStuClass(){
        List<Stuclass> list = stuclassMapper.findAllStuClass();
        for (Stuclass s:list) {
            System.out.println(s);
        }
    }

    /**
     * 添加班级
     */
    @Test
    public void testInsertClass(){
        Stuclass sclass = new Stuclass("CLS995","网工2","卢彪","网络工程");
        stuclassMapper.insertClass(sclass);
    }

    /**
     * 根据班级编号(claName)删除班级
     */
    @Test
    public void testDelClassByClsNum(){
        stuclassMapper.delClassByClsNum("CLS995");
    }

    /**
     * 根据班级编号修改班级
     */
    @Test
    public void testUpdateClassByClsNum(){
        Stuclass sclass = new Stuclass("CLS999","Test计科1","T997","计算机科学与技术");
        stuclassMapper.updateClassByClsNum(sclass);
    }

}
