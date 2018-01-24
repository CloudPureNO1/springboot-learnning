package com.springboot.learnning.mybatis2.service.imp;

import com.springboot.learnning.mybatis2.mapper.UserMapper;
import com.springboot.learnning.mybatis2.model.User;
import com.springboot.learnning.mybatis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertUser(Long id, String name, String passwd, String addr) {
        return userMapper.insertUser(id,name,passwd,addr);
    }
}
