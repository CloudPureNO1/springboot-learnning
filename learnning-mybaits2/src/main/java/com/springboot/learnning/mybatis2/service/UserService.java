package com.springboot.learnning.mybatis2.service;

import com.springboot.learnning.mybatis2.model.User;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
public interface UserService {
    User getUserById(Long id);
    List<User> getAll();
    int insert(User user);
    int insertUser(Long id,String name,String passwd,String addr);
}
