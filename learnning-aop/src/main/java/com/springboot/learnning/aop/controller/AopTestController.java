package com.springboot.learnning.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2018/1/8.
 */
@Controller
public class AopTestController {

    @RequestMapping(value="/msg",method = RequestMethod.POST)
    @ResponseBody
    public String showMsg(){
        System.out.println("测试开始");
        return"测试成功";
    }

    @RequestMapping(value="/msg2")
    public String showException(){
        int i=1/0;

        return "异常！";
    }
}
