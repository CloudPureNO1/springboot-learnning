package com.springboot.learnning.aop.controller;

import com.springboot.learnning.aop.annotation.UserAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

/**
 * Created by CloudPure on 2018/1/8.
 */
@Controller
@UserAnnotation(desc="wangsm")
public class UserController {
    @RequestMapping(value = "/userMsg",method = RequestMethod.POST)
    @ResponseBody
    public String userMsg(){
        return "user msg Ok";
    }
}
