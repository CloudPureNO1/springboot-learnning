package com.springboot.learnning.myexception.controller;

import com.springboot.learnning.myexception.domain.ResultInfo;
import com.springboot.learnning.myexception.domain.enums.ExceptionEnum;
import com.springboot.learnning.myexception.domain.exception.BaseException;
import com.springboot.learnning.myexception.util.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by CloudPure on 2017/12/21.
 */
@RestController
public class TestController {
private static final Logger logger=Logger.getLogger(TestController.class);
    @RequestMapping(value="/msg")
    public String showMsg(){
        int i=Integer.parseInt("1221213fd");
        return "hello";
    }

    @RequestMapping(value="/msg2")
    public String showMsg2() throws ParseException {

        try {
            new SimpleDateFormat("yyyyMMdd").parse("121w2");
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }

        return "haha";
    }

    @RequestMapping(value="/msg3")
    public String showmsg3() throws BaseException {
        ResultInfo info=null;
        if(info==null)
                throw new BaseException(12345,"测试 BaseExcetpion");
            return "dd";
    }

    @RequestMapping(value="/msg4")

    public String showmsg4(){
        ResultInfo info=null;
        String msg=info.getMsg();
        return "dd";
    }

}
