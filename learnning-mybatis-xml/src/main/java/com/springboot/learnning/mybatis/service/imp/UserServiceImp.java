package com.springboot.learnning.mybatis.service.imp;

import com.springboot.learnning.mybatis.mapper.UserMapper;
import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/25.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public int delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    @Transactional
    public int update(Long id,String name,String passwd,String addr) {
        return userMapper.update(id,name,passwd,addr);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
