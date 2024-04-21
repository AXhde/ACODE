package com.szxy.service;

import com.szxy.eneity.Stuclass;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/23 0023.
 * 班级表service
 */
public interface StuclassService {

    /**
     * 查询所有班级
     */
    List<Stuclass> findAllStuClass();

    /**
     * 添加班级
     */
    void insertClass(Stuclass stuclass);

    /**
     * 根据班级编号(claName)删除班级
     */
    void delClassByClsNum(String claNum);

    /**
     * 根据班级编号(claName)查询班级
     */
    Stuclass findClassByClsNum(String claNum);

    /**
     * 根据班级编号修改班级
     */
    void updateClassByClsNum(Stuclass stuclass);
}
