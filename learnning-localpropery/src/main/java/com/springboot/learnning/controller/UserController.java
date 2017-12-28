package com.springboot.learnning.controller;

import com.springboot.learnning.myconfig.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2017/12/28.
 */
@Controller
public class UserController {
    @Autowired
    private UserConfig userConfig;

    @RequestMapping(value="user",method = RequestMethod.POST)
    @ResponseBody
    public String getUser(){
        return userConfig.getUsername()+"\t"+userConfig.getUserpasswd();
    }
}
