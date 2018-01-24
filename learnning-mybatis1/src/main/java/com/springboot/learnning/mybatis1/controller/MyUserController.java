package com.springboot.learnning.mybatis1.controller;

import com.springboot.learnning.mybatis1.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Controller
@RequestMapping(value="/myUser")
public class MyUserController {
    @Autowired
    private MyUserService myUserService;

    @RequestMapping(value="/find")
    @ResponseBody
    public String getAll(){
        return myUserService.getAll().toString();
    }


}
