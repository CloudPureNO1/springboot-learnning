package com.springboot.learnning.mybatisok.service;

import com.springboot.learnning.mybatisok.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/16.
 */
public interface UserService {
    int insert(User user);
    int delete(User user);
    User findById(Long userid);
    List<User> findByName(String name);
    List<User> findAll();
}
