package com.springboot.learnning.mybatis.model;

/**
 *
 * Created by CloudPure on 2018/1/25.
 */
public class User implements java.io.Serializable{
    private Long userId;
    private String userName;
    private String userPasswd;
    private String userAddr;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        if (getUserPasswd() != null ? !getUserPasswd().equals(user.getUserPasswd()) : user.getUserPasswd() != null)
            return false;
        return getUserAddr() != null ? getUserAddr().equals(user.getUserAddr()) : user.getUserAddr() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getUserPasswd() != null ? getUserPasswd().hashCode() : 0);
        result = 31 * result + (getUserAddr() != null ? getUserAddr().hashCode() : 0);
        return result;
    }

    public User() {
    }

    public User(Long userId, String userName, String userPasswd, String userAddr) {
        this.userId = userId;
        this.userName = userName;
        this.userPasswd = userPasswd;
        this.userAddr = userAddr;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }
}
