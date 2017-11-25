package com.springboot.learnning.web.learnningweb.controller;

import com.springboot.learnning.domain.learnningdomain.pojo.MsgTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class MsgTestController {
    @Value("${application.username}")
    private String username;
    @Value("${application.hello}")
    private String hello;
    @Value("${application.greeting}")
    private String greeting;
    @Value("${application.discription}")
    private String discription;

    @Autowired
    private  MsgTest msgTest;

    @RequestMapping(value="/msg",method = RequestMethod.GET)
    public String showMsg(HashMap<String,Object> map){
        map.put("msg",hello+"!"+username+","+greeting);
        map.put("desc",discription);
        map.put("msg2","非常有趣");
        return "msgTest";
    }

    @RequestMapping(value = "/detailMsg")
    public ModelAndView showDetailMsg(){
        msgTest.setDiscription(discription);
        msgTest.setGreeting(greeting);
        msgTest.setHello(hello);
        msgTest.setUsername(username);
        ModelAndView modelAndView=new ModelAndView("/detailTestMsg");
       modelAndView.addObject("msgTest",msgTest);
       return modelAndView;
    }

}
