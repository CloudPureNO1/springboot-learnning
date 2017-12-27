package com.springboot.learnning.controller;

import com.springboot.learnning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Controller
@RequestMapping(value="user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="getUser")
    @ResponseBody
    public String getAllUser(){
        return userService.findAll().toString();
    }

    @RequestMapping(value="getUser1")
    @ResponseBody
    public String getAllUser1(){
        return userService.findAll1().toString();
    }
}
