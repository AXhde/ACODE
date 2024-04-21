package com.szxy.eneity;

import java.io.Serializable;

/**
 * Created by Mr.z on 2018/4/8 0008.
 * 课程信息表
 */
public class Courses implements Serializable{

    private static final long serialVersionUID = 3259783253773016436L;

    private Integer couId;
    //课程号
    private String couNum;
    //课程名
    private String couName;
    //学时
    private String couhour;
    //授课教师
    private String teaName;

    public Courses() {
    }

    public Courses(String couNum, String couName, String couhour, String teaName) {
        this.couNum = couNum;
        this.couName = couName;
        this.couhour = couhour;
        this.teaName = teaName;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public String getCouNum() {
        return couNum;
    }

    public void setCouNum(String couNum) {
        this.couNum = couNum;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getCouhour() {
        return couhour;
    }

    public void setCouhour(String couhour) {
        this.couhour = couhour;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Courses{");
        sb.append("couId=").append(couId);
        sb.append(", couNum='").append(couNum).append('\'');
        sb.append(", couName='").append(couName).append('\'');
        sb.append(", couhour='").append(couhour).append('\'');
        sb.append(", teaName='").append(teaName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
