package com.springboot.learnning.mybatis2.controller;

import com.springboot.learnning.mybatis2.model.User;
import com.springboot.learnning.mybatis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/user",method= RequestMethod.POST)
    @ResponseBody
    public String getUser(@RequestParam("id") Long id){
        return userService.getUserById(id)+"";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public String getList(){
        List<User>list=userService.getAll();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+list.size());
        for (User user:list){
            System.out.println(">>>>>>>>>>>"+user.toString());
        }
        return list.size()>0?list.get(0).toString():"空";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestParam("userId")Long userId,@RequestParam("userName") String userName,@RequestParam("userPasswd") String userPasswd,@RequestParam("userAddr") String userAddr){
        User user=new User();
        user.setUserName(userName);
        user.setUserId(userId);
        user.setUserPasswd(userPasswd);
        user.setUserAddr(userAddr);
        return userService.insert(user)+"";
    }

    @RequestMapping(value="/insertUser",method = RequestMethod.POST)
    @ResponseBody
    public String insertUser(@RequestParam("id") Long id,@RequestParam("userName") String name,@RequestParam("passwd") String passwd,@RequestParam String addr){
        return userService.insertUser(id,name,passwd,addr)+"";
    }


}
