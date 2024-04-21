package com.szxy.mapper;

import com.szxy.eneity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/15 0015.
 */
@ContextConfiguration(locations = {"classpath:springmvc/springmvc.xml","classpath:spring/*.xml"})
public class testScoreMapper extends AbstractTestNGSpringContextTests{

    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 根据学号查询该学生所有选课,成绩
     */
    @Test
    public void testFindScoreByStuNum(){
        List<Score> list = scoreMapper.findScoreByStuNum("S20149999");
        for (Score sc: list) {
            System.out.println(sc);
        }
    }

    /**
     * 添加一条选课信息
     */
    @Test
    public void testInsertScore(){
        Score sc = new Score("S20149995","C#",null);
        scoreMapper.insertScore(sc);
    }

    /**
     * 根据学号,课程名删除一条选课,成绩
     */
    @Test
    public void testDelScoreByStuNumcouName(){
        scoreMapper.delScoreByStuNumcouName("S20149995","C#");
    }

    /**
     * 据学号,删除该学生所有选课,成绩
     */
    @Test
    public void testDelAllScoreByStuNum(){
        scoreMapper.delAllScoreByStuNum("S20149995");
    }

    /**
     * 根据学号,课程名,更新学生成绩
     */
    @Test
    public void testUpdateScoreByStuNumCouName(){
        Score sc = new Score("S20149995","C#","100");
        scoreMapper.updateScoreByStuNumCouName(sc);
    }
}
