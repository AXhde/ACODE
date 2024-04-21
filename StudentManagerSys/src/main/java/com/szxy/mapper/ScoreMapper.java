package com.szxy.mapper;

import com.szxy.eneity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 选课,成绩操作
 */
public interface ScoreMapper {

    /**
     * 根据学号查询该学生所有选课,成绩
     */
    List<Score> findScoreByStuNum(String stuNum);

    /**
     * 添加一条选课信息
     */
    void insertScore(Score score);

    /**
     * 根据学号,课程名删除一条选课,成绩
     */
    void delScoreByStuNumcouName(@Param("stuNum") String stuNum, @Param("couName") String couName);

    /**
     * 据学号,删除该学生所有选课,成绩
     */
    void delAllScoreByStuNum(String stuNum);

    /**
     * 根据学号,课程名,更新学生成绩
     */
    void updateScoreByStuNumCouName(Score score);
}
