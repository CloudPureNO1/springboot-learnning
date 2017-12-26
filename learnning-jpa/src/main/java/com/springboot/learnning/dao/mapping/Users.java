package com.springboot.learnning.dao.mapping;

import javax.persistence.*;

/**
 * Created by CloudPure on 2017/12/25.
 */
@Entity
@Table(name = "my_users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name="user_passwd",nullable = false)
    private String userPasswd;

    public void setUserid(Integer id){
        this.userId=id;
    }
    public Integer getUserId(){
        return this.userId;
    }
    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserpasswd(String pw){
        this.userPasswd=pw;
    }
    public String getUserPasswd(){
        return this.userPasswd;
    }

    public Users(){

    }

    public Users(Integer id,String name,String pd){
        this.userId=id;
        this.userName=name;
        this.userPasswd=pd;
    }

    @Override
    public String toString(){
        return "[userId:"+userId+",userName:"+userName+",userPasswd:"+userPasswd+"]";
    }

 /*   @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Users )) return false;
        Users users= (Users) o;
        if(getUserId()!=null? !getUserId().equals(users.getUserId()):users.getUserId()!=null) return false;
        if(getUserName()!=null? !getUserName().equals(users.getUserName()):users.getUserName()!=null) return false;
        if(getUserPasswd()!=null? !getUserPasswd().equals(users.getUserPasswd()):users.getUserPasswd()!=null) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result=getUserId()!=null?getUserId().hashCode():0;
        result=31*result+(getUserName()!=null?getUserName().hashCode():0);
        result =31*result+(getUserPasswd()!=null?getUserPasswd().hashCode():0);
        return result;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (getUserId() != null ? !getUserId().equals(users.getUserId()) : users.getUserId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(users.getUserName()) : users.getUserName() != null)
            return false;
        return getUserPasswd() != null ? getUserPasswd().equals(users.getUserPasswd()) : users.getUserPasswd() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getUserPasswd() != null ? getUserPasswd().hashCode() : 0);
        return result;
    }
}
