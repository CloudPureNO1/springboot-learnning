package com.springboot.learnning.junit.service;

import com.springboot.learnning.junit.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/26.
 */
public interface UserService {
    List<User> getUserByList(List<Long>list);
    List<User>getUserByArray(Long [] array);
    List<User>getUserByMap(Map<String,Object> map);
}
