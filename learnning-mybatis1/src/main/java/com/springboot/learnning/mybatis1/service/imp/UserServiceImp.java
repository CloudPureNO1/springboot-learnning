package com.springboot.learnning.mybatis1.service.imp;

import com.springboot.learnning.mybatis1.mapper.UserMapper;
import com.springboot.learnning.mybatis1.model.User;
import com.springboot.learnning.mybatis1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }



    @Override
    public List<User> findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    @Transactional
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

}
