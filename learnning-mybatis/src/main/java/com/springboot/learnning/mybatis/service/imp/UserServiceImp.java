package com.springboot.learnning.mybatis.service.imp;

import com.springboot.learnning.mybatis.mapper.UserMapper;
import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/15.
 */
@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int deleteByUserName(String userName) {
        return userMapper.deleteByUserName(userName);
    }

    @Override
    public List<User> findListUser() {
        return userMapper.findListUser();
    }
}
