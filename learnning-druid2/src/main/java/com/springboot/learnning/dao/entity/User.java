package com.springboot.learnning.dao.entity;

import javax.persistence.*;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Entity
@Table(name="my_users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_passwd")
    private String userPssswd;

    public void setUserId(Long id){
        this.userId=id;
    }
    public Long getUserId(){
        return userId;
    }
    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserPssswd(String pd){
        this.userPssswd=pd;
    }
    public String getUserPssswd(){
        return userPssswd;
    }
    public User(){}
    public User(Long id,String name,String pd){
        this.userId=id;
        this.userName=name;
        this.userPssswd=pd;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof User)) return false;
        User user= (User) obj;
        if(getUserId()!=null? !getUserId().equals(user.getUserId()):user.getUserId()!=null) return false;
        if(getUserName()!=null? !getUserName().equals(user.getUserName()):user.getUserName()!=null) return false;
        if(getUserPssswd()!=null? !getUserPssswd().equals(user.getUserPssswd()):user.getUserPssswd()!=null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result=getUserId()!=null?getUserId().hashCode():0;
        result=31*result+getUserName()!=null?getUserName().hashCode():0;
        result=31*result+getUserPssswd()!=null?getUserPssswd().hashCode():0;
        return result;
    }

    @Override
    public String toString() {
        return "[" +
                "userId:" + userId +
                ", userName:'" + userName + '\'' +
                ", userPssswd:'" + userPssswd + '\'' +
                ']';
    }
}
