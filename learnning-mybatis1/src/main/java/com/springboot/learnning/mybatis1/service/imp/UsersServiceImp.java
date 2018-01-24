package com.springboot.learnning.mybatis1.service.imp;

import com.springboot.learnning.mybatis1.model.MyUser;
import com.springboot.learnning.mybatis1.model.User;
import com.springboot.learnning.mybatis1.service.MyUserService;
import com.springboot.learnning.mybatis1.service.UserService;
import com.springboot.learnning.mybatis1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    private UserService userService;
    @Autowired
    private MyUserService myUserService;
    @Override
    @Transactional
    public Long save(User user) {
         userService.insert(user);
         Long userid=userService.getUserById(user.getUserId()).getUserId();
         MyUser myUser=new MyUser();
         myUser.setUserid(userid);
         myUser.setUsername("wxy");
         myUser.setPasswd("wxy123456");
         myUser.setAddr("hangzhou");
         myUserService.insert(myUser);
         return userid;
    }
}
