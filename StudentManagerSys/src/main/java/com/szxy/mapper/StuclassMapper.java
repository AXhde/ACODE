package com.szxy.mapper;


import com.szxy.eneity.Stuclass;

import java.util.List;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 班级信息操作
 */
public interface StuclassMapper {

    /**
     * 查询所有班级
     */
    List<Stuclass> findAllStuClass();

    /**
     * 添加班级
     */
    void insertClass(Stuclass stuclass);

    /**
     * 根据班级编号(claName)查询班级
     */
    Stuclass findClassByClsNum(String claNum);

    /**
     * 根据班级编号(claName)删除班级
     */
    void delClassByClsNum(String claNum);

    /**
     * 根据班级编号修改班级
     */
    void updateClassByClsNum(Stuclass stuclass);
}
