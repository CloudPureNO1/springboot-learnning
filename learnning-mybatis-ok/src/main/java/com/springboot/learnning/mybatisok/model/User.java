package com.springboot.learnning.mybatisok.model;

/**
 * Created by CloudPure on 2018/1/16.
 */
public class User {
    private Long userid;

    private String username;

    private String passwd;

    private String addr;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
