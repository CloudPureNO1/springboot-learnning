package com.springboot.learnning.mybatisok.service.imp;

import com.springboot.learnning.mybatisok.mapper.UserMapper;
import com.springboot.learnning.mybatisok.model.User;
import com.springboot.learnning.mybatisok.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/16.
 */
@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user.getUserid());
    }

    @Override
    public User findById(Long userid) {
        return userMapper.findById(userid);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
