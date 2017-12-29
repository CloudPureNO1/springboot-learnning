package com.springboot.learnning.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CloudPure on 2017/12/29.
 */
@Controller
public class IndexController {
    @RequestMapping(value="/index",method = RequestMethod.POST)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("msg","hello");
        return modelAndView;
    }

    public String msg(){
        return "this is a msessage from springboot!";
    }


}
