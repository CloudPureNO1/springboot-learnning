package com.springboot.learnning.mybatis2.service.imp;

import com.springboot.learnning.mybatis2.mapper.UserMappper;
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
    private UserMappper userMappper;
    @Override
    public int save(User user) {
        return userMappper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMappper.update(user);
    }

    @Override
    public int delete(Long userId) {
        return userMappper.delete(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userMappper.getUserById(userId);
    }

    @Override
    public List<User> getAll() {
        return userMappper.getAll();
    }

    @Override
    public int updateUser(Long id, String name, String passwd) {
        return userMappper.updateUser(id,name,passwd);
    }
}
