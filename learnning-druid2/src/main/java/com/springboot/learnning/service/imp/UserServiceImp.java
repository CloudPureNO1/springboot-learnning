package com.springboot.learnning.service.imp;

import com.springboot.learnning.dao.JPARepository;
import com.springboot.learnning.dao.entity.User;
import com.springboot.learnning.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Service
public class UserServiceImp implements UserService{
    @Resource
    private JPARepository repository;

    @Override
    public List<User> getAll() {
        List<User>list=new ArrayList<User>();
        Iterable<User> iterable=repository.findAll();
        for(User user:iterable){
            list.add(user);
        }
        return list;
    }
}
