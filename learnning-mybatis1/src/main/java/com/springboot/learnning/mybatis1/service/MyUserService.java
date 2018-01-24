package com.springboot.learnning.mybatis1.service;

import com.springboot.learnning.mybatis1.model.MyUser;
import com.springboot.learnning.mybatis1.model.User;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
public interface MyUserService {
    List<MyUser> getAll();
    int insert(MyUser user) ;
}
