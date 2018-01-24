package com.springboot.learnning.mybatis2.service;

import com.springboot.learnning.mybatis2.model.User;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
public interface UserService {
    int save(User user);
    int update(User user);
    int delete(Long userId);
    User getUserById(Long userId);
    List<User> getAll();

    int updateUser(Long id,String name,String passwd);
}
