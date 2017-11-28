package com.springboot.learnning.hotload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CloudPure on 2017/11/28.
 */
@Controller
public class HotloadController {

    @RequestMapping(value="/msg")
    @ResponseBody
    public String msg(){
        return "111这个是hello111";
    }

    @RequestMapping(value="/msgShow")
    public ModelAndView showMsg(){
        ModelAndView modelAndView=new ModelAndView("showMsg");
        modelAndView.addObject("showMsg","这个是message！");
        return modelAndView;
    }
}
