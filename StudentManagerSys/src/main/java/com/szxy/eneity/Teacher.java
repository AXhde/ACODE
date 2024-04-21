package com.szxy.eneity;

import java.io.Serializable;

/**
 * Created by Mr.z on 2018/4/8 0008.
 * 教师表
 */
public class Teacher implements Serializable{

    private static final long serialVersionUID = 4098243721625844191L;

    private Integer teaId;
    //教师编号
    private String teaNum;
    //教师姓名
    private String teaName;
    //联系电话
    private String teaPhone;

    public Teacher() {
    }

    public Teacher(String teaNum, String teaName, String teaPhone) {
        this.teaNum = teaNum;
        this.teaName = teaName;
        this.teaPhone = teaPhone;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("teaId=").append(teaId);
        sb.append(", teaNum='").append(teaNum).append('\'');
        sb.append(", teaName='").append(teaName).append('\'');
        sb.append(", teaPhone='").append(teaPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
