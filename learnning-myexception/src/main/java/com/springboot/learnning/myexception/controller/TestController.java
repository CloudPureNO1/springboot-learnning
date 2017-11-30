package com.springboot.learnning.myexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CloudPure on 2017/11/30.
 */
@Controller
public class TestController {

    @RequestMapping(value="/msg")
    @ResponseBody
    public String showMsg(){
        String str="asdfasd";
        int  i=Integer.parseInt(str);
        return "hello";
    }
}
