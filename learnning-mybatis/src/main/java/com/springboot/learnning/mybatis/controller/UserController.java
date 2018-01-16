package com.springboot.learnning.mybatis.controller;

import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import com.springboot.learnning.mybatis.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/15.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/insert")
    @ResponseBody
    public String insertUser(){
        User user=new User();
        user.setUserId(1001L);
        user.setUserName("王沐毅");
        user.setUserPasswd("wangsm");
        user.setUserAddr("杭州西湖");
        int i=userService.insert(user);
        return "成功插入了"+i+"条数据";
    }

    @RequestMapping(value="deleteByName")
    @ResponseBody
    public String deleteByUserName(){
        int i=userService.deleteByUserName("王沐毅");
        return "成功删除了"+i+"条数据";
    }

    @RequestMapping(value="findAll")
    @ResponseBody
    public String findAll(){
        List<User> list=userService.findListUser();
        return list.toString();
    }
}
