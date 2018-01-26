package com.springboot.learnning.mybatis.service.imp;

import com.springboot.learnning.mybatis.mapper.UserMapper;
import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/25.
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
    @Transactional
    public int delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    @Transactional
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getByProperties(User user) {
        return userMapper.selectByProperties(user);
    }

    @Override
    public List<User> selectByConditions(User user) {
        return userMapper.selectByConditions(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> selectUserByList(List<Long> list) {
        return userMapper.selectUserByList(list);
    }

    @Override
    public List<User> selectUserByArray(Long[] aIds) {
        return userMapper.selectUserByArray(aIds);
    }

    @Override
    public List<User> selectUserByMap(Map<String, ?> map) {
        return userMapper.selectUserByMap(map);
    }
}
