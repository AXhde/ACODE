package com.szxy.eneity;

import java.io.Serializable;

/**
 * Created by Mr.z on 2018/4/8 0008.
 * 管理员表
 */
public class Admin implements Serializable{

    private static final long serialVersionUID = 4309608709978676218L;

    //管理员姓名
    private String admName;
    //账号
    private String admNum;
    //密码
    private String admPsw;

    public Admin() {
    }

    public Admin(String admName, String admNum, String admPsw) {
        this.admName = admName;
        this.admNum = admNum;
        this.admPsw = admPsw;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmNum() {
        return admNum;
    }

    public void setAdmNum(String admNum) {
        this.admNum = admNum;
    }

    public String getAdmPsw() {
        return admPsw;
    }

    public void setAdmPsw(String admPsw) {
        this.admPsw = admPsw;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Admin{");
        sb.append("admName='").append(admName).append('\'');
        sb.append(", admNum='").append(admNum).append('\'');
        sb.append(", admPsw='").append(admPsw).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
