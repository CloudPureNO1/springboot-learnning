package com.springboot.learnning.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CloudPure on 2017/11/28.
 */
@Controller
public class MsgController {
    @RequestMapping("/msg")
    public String showMsg(){
        int i=100/0;
        return i+"";
    }
}
