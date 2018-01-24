package com.springboot.learnning.mybatis1.service;

import com.springboot.learnning.mybatis1.model.User;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
public interface UserService {
    int insert(User user);
    List<User> findAll();
    List<User> findByName(String username);
    int insertUser(User user);
    User getUserById(Long id);
}
