package com.springboot.learnning.web.learnningweb.controller;

import com.springboot.learnning.domain.learnningdomain.pojo.MsgTest;
import com.springboot.learnning.web.learnningweb.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMsgTestController {
    @Value("${application.username}")
    private String username;
    @Value("${application.hello}")
    private String hello;
    @Value("${application.greeting}")
    private String greeting;
    @Value("${application.discription}")
    private String discription;

    @Autowired
    private   MsgTest msgTest;
    @Autowired
    private TestVO testVO;

    @RequestMapping(value="/showMsg")
    public String showMsg(){
        msgTest.setDiscription(discription);
        msgTest.setGreeting(greeting);
        msgTest.setHello(hello);
        msgTest.setUsername(username);
        return msgTest.toString();
    }


    @RequestMapping(value="/showMsg2")
    public String showMsg2(){
        testVO.setMsg("测试信息");
        return testVO.toString();
    }
}
