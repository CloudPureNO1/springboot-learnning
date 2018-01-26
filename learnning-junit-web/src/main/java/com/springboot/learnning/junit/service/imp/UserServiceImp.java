package com.springboot.learnning.junit.service.imp;

import com.springboot.learnning.junit.mapper.UserMapper;
import com.springboot.learnning.junit.model.User;
import com.springboot.learnning.junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/26.
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserByList(List<Long> list) {
        return userMapper.getUserByList(list);
    }

    @Override
    public List<User> getUserByArray(Long[] array) {
        return userMapper.getUserByArray(array);
    }

    @Override
    public List<User> getUserByMap(Map<String, Object> map) {
        return userMapper.getUserByMap(map);
    }
}
