package com.springboot.learnning.myexception.controller;

import com.springboot.learnning.myexception.domain.exception.BaseException;
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

    @RequestMapping(value="/msg2")
    @ResponseBody
    public String showMsg2() throws BaseException {
        try {
            String str = "12123r";
            int i = Integer.parseInt(str);
            return "hello";
        }catch(NumberFormatException ne){
            throw new BaseException("数据格式化异常！"+ne.getMessage(),-200);
        }
    }
}
