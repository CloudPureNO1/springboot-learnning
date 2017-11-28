package com.springboot.learnning.thymeleaf2.domain;

/**
 * Created by CloudPure on 2017/11/28.
 */
public class User {
    private String username;
    private String pwssword;

    public User(String username, String pwssword) {
        this.username = username;
        this.pwssword = pwssword;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwssword() {
        return pwssword;
    }

    public void setPwssword(String pwssword) {
        this.pwssword = pwssword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        return getPwssword() != null ? getPwssword().equals(user.getPwssword()) : user.getPwssword() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPwssword() != null ? getPwssword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwssword='" + pwssword + '\'' +
                '}';
    }
}
