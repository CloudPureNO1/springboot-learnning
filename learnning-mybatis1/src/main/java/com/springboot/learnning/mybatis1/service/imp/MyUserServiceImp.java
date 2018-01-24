package com.springboot.learnning.mybatis1.service.imp;

import com.springboot.learnning.mybatis1.mapper.MyUserMapper;
import com.springboot.learnning.mybatis1.model.MyUser;
import com.springboot.learnning.mybatis1.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Service
public class MyUserServiceImp implements MyUserService {
    @Autowired
    private MyUserMapper myUserMapper;
    @Override
    public List<MyUser> getAll() {
        return myUserMapper.getAll();
    }

    @Override
    public int insert(MyUser user) {
        return myUserMapper.insert(user);
    }
}
