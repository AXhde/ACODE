package com.szxy.service.impl;

import com.szxy.eneity.Stuclass;
import com.szxy.mapper.StuclassMapper;
import com.szxy.service.StuclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/23 0023.
 * 班级表service实现
 */
@Service
@Transactional
public class StuclassServiceImpl implements StuclassService{

    @Autowired
    private StuclassMapper stuclassMapper;

    @Override
    public List<Stuclass> findAllStuClass() {
        List<Stuclass> list = stuclassMapper.findAllStuClass();
        return list;
    }

    @Override
    public void insertClass(Stuclass stuclass) {
        stuclassMapper.insertClass(stuclass);
    }

    @Override
    public void delClassByClsNum(String claNum) {
        stuclassMapper.delClassByClsNum(claNum);
    }

    @Override
    public Stuclass findClassByClsNum(String claNum) {
        return stuclassMapper.findClassByClsNum(claNum);
    }

    @Override
    public void updateClassByClsNum(Stuclass stuclass) {
        stuclassMapper.updateClassByClsNum(stuclass);
    }
}
