package com.springboot.learnning.mybatis1.controller;

import com.springboot.learnning.mybatis1.model.User;
import com.springboot.learnning.mybatis1.service.UserService;
import com.springboot.learnning.mybatis1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Controller
@RequestMapping(value="/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value="/save")
    @ResponseBody
    public String  save(@RequestParam("userid") Long userid){
        User user=new User();
        user.setUserId(userid);
        user.setUserAddr("hangz");
        user.setUserName("wangsm57");
        user.setUserPasswd("halou");
        Long userId=usersService.save(user);
        return "保存成功：userid 为："+userId;
    }
}
