package com.kuangjia.main.model;

import java.io.Serializable;

/**
 * Created by zhangshuai on 2017-01-06.
 */

public class User implements Serializable {

    private String UserName;
    private String UserPwd;
    private String nihao;

    public String getNihao() {
        return nihao;
    }

    public void setNihao(String nihao) {
        this.nihao = nihao;
    }

    public String getUserName() {  return UserName;  }
    public void setUserName(String userName) {  UserName = userName;  }

    public String getUserPwd() { return UserPwd; }
    public void setUserPwd(String userPwd) { UserPwd = userPwd; }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", UserPwd='" + UserPwd + '\'' +
                ", nihao='" + nihao + '\'' +
                '}';
    }
}
