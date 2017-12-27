package com.springboot.learnning.service;

import com.springboot.learnning.dao.mapping.User;

import java.util.List;

/**
 * Created by CloudPure on 2017/12/27.
 */
public interface UserService {
    User save(User u);

    void delete(User u);

    boolean update(User u);

    User getUser(Integer id);

    List<User> findAll();

    List<User> findAll1();
}
