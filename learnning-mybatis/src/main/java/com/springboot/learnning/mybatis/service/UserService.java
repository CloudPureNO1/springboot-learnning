package com.springboot.learnning.mybatis.service;

import com.springboot.learnning.mybatis.model.User;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/15.
 */
public interface UserService {
    int insert(User record);
    int deleteByPrimaryKey(Long userId);
    int deleteByUserName(String userName);
    List<User> findListUser();

}
