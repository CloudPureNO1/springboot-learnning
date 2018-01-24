package com.springboot.learnning.mybatis1.controller;

import com.springboot.learnning.mybatis1.model.User;
import com.springboot.learnning.mybatis1.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Base64;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/save/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String insert(@PathVariable("id") Long id,@RequestParam("username") String username,@RequestParam("passwd") String passwd){
        User user=new User();
        user.setUserId(id);
        user.setUserName(username);
        user.setUserPasswd(Base64.getEncoder().encodeToString(passwd.getBytes()));
        user.setUserAddr("hangzou");
        int i=userService.insert(user);
        return "成功插入了："+i+"条数据！";
    }

    @RequestMapping(value="/find")
    @ResponseBody
    public String findAll(@RequestParam("username") String username){
        List<User>list=userService.findByName(username);
        return  list.toString();
    }

    @RequestMapping(value="/insertUser")
    @ResponseBody
    public String insertUser(){
        User user=new User();
        user.setUserName("wangsm222");
        user.setUserPasswd("wangsm123456");
        user.setUserAddr("hangz");
        int i=userService.insertUser(user);
        return "成功插入了:"+i+"条数据";
    }
}
