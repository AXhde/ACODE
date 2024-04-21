package com.szxy.service.impl;

import com.szxy.eneity.Score;
import com.szxy.mapper.ScoreMapper;
import com.szxy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.z on 2018/5/1 0001.
 * ScoreServiceImpl
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> findScoreByStuNum(String stuNum) {
        return scoreMapper.findScoreByStuNum(stuNum);
    }

    @Override
    public void insertScore(Score score) {
        scoreMapper.insertScore(score);
    }

    @Override
    public void delScoreByStuNumcouName(String stuNum, String couName) {
        scoreMapper.delScoreByStuNumcouName(stuNum,couName);
    }

    @Override
    public void delAllScoreByStuNum(String stuNum) {
        scoreMapper.delAllScoreByStuNum(stuNum);
    }

    @Override
    public void updateScoreByStuNumCouName(Score score) {
        scoreMapper.updateScoreByStuNumCouName(score);
    }
}
