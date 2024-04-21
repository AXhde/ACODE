package com.szxy.eneity;

import java.io.Serializable;

/**
 * Created by Mr.z on 2018/4/11 0011.
 * 班级信息表
 */
public class Stuclass implements Serializable{

    private static final long serialVersionUID = 4205216743103705734L;

    private Integer clsId;
    //班级编号
    private String clsNum;
    //班级名
    private String clsName;
    //班主任
    private String teaName;
    //专业名称
    private String department;

    public Stuclass() {
    }

    public Stuclass(String clsNum, String clsName, String teaName, String department) {
        this.clsNum = clsNum;
        this.clsName = clsName;
        this.teaName = teaName;
        this.department = department;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public String getClsNum() {
        return clsNum;
    }

    public void setClsNum(String clsNum) {
        this.clsNum = clsNum;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stuclass{");
        sb.append("clsId=").append(clsId);
        sb.append(", clsNum='").append(clsNum).append('\'');
        sb.append(", clsName='").append(clsName).append('\'');
        sb.append(", teaName='").append(teaName).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
