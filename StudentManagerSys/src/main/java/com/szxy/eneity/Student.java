package com.szxy.eneity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mr.z on 2018/4/8 0008.
 * 学生信息表
 */
public class Student implements Serializable{

    private static final long serialVersionUID = 5092563611277015364L;

    private Integer stuId;
    //学号
    private String stuNum;
    //姓名
    private String stuName;
    //密码
    private String stuPsw;
    //班级名
    private String clsName;
    //性别
    private String Sex;
    //联系电话
    private String stuPhone;
    //入学时间
    private String createDate;
    //地址
    private String stuAddress;
    //备注
    private String stuElse;

    public Student() {
    }

    public Student(String stuNum, String stuName, String stuPsw, String clsName, String sex, String stuPhone, String createDate, String stuAddress, String stuElse) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuPsw = stuPsw;
        this.clsName = clsName;
        Sex = sex;
        this.stuPhone = stuPhone;
        this.createDate = createDate;
        this.stuAddress = stuAddress;
        this.stuElse = stuElse;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPsw() {
        return stuPsw;
    }

    public void setStuPsw(String stuPsw) {
        this.stuPsw = stuPsw;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuElse() {
        return stuElse;
    }

    public void setStuElse(String stuElse) {
        this.stuElse = stuElse;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("stuId=").append(stuId);
        sb.append(", stuNum='").append(stuNum).append('\'');
        sb.append(", stuName='").append(stuName).append('\'');
        sb.append(", stuPsw='").append(stuPsw).append('\'');
        sb.append(", clsName='").append(clsName).append('\'');
        sb.append(", Sex='").append(Sex).append('\'');
        sb.append(", stuPhone='").append(stuPhone).append('\'');
        sb.append(", createDate='").append(createDate).append('\'');
        sb.append(", stuAddress='").append(stuAddress).append('\'');
        sb.append(", stuElse='").append(stuElse).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
