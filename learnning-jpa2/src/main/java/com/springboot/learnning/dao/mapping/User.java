package com.springboot.learnning.dao.mapping;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by CloudPure on 2017/12/26.
 */
@Entity
@Table(name="my_users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_passwd")
    private String userPasswd;

    public Integer getUserId(){
        return this.userId;
    }
    public void setUserId(Integer id){
        this.userId=id;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserPasswd(){
        return userPasswd;
    }
    public void setUserPasswd(String pd){
        this.userPasswd=pd;
    }
    public User(){}
    public User(Integer id,String name,String pd){
        this.userId=id;
        this.userName=name;
        this.userPasswd=pd;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(!(obj instanceof User)) return false;
        User u= (User) obj;
        if(getUserId()!=null? !getUserId().equals(u.getUserId()):u.getUserId()!=null) return false;
        if(getUserName()!=null? !getUserName().equals(u.getUserName()):u.getUserName()!=null) return false;
        if(getUserPasswd()!=null? !getUserPasswd().equals(u.getUserPasswd()):u.getUserPasswd()!=null)return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result =getUserId()!=null? getUserId().hashCode():0;
        result=31*result+getUserName()!=null? getUserName().hashCode():0;
        result=31*result+getUserPasswd()!=null? getUserPasswd().hashCode():0;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }
}
