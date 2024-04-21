package com.szxy.eneity;

import java.io.Serializable;

/**
 * Created by Mr.z on 2018/4/8 0008.
 * 选课,成绩
 */
public class Score implements Serializable{

    private static final long serialVersionUID = -2043066071599196897L;
    //
    private Integer scId;
    //学生学号
    private String stuNum;
    //课程名
    private String couName;
    //课程成绩
    private String scScore;

    public Score() {
    }

    public Score(String stuNum, String couName, String scScore) {
        this.stuNum = stuNum;
        this.couName = couName;
        this.scScore = scScore;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getScScore() {
        return scScore;
    }

    public void setScScore(String scScore) {
        this.scScore = scScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score{");
        sb.append("scId=").append(scId);
        sb.append(", stuNum='").append(stuNum).append('\'');
        sb.append(", couName='").append(couName).append('\'');
        sb.append(", scScore='").append(scScore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
