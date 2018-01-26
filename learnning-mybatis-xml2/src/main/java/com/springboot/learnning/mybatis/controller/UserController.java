package com.springboot.learnning.mybatis.controller;

import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/25.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUserByProperties" ,method = RequestMethod.POST)
    @ResponseBody
    public String getUserByProperties(@RequestParam("userId") Long id, @RequestParam("userName") String name, @RequestParam("userPasswd") String passwd,
                                      @RequestParam("userAddr") String addr){
        User user=new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserPasswd(passwd);
        user.setUserAddr(addr);
        List<User> list=userService.getByProperties(user);
        String str="";
        for(User u:list){
           str+= u.getUserId()+":"+u.getUserName()+"\n";
        }
        return str;
    }



    @RequestMapping(value="/updateUser" ,method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestParam("userId") Long id,@RequestParam("userName") String name,@RequestParam("userPasswd") String passwd,@RequestParam("userAddr") String addr){
        User user=new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserPasswd(passwd);
        user.setUserAddr(addr);
        return userService.updateUser(user)+"";
    }
    @RequestMapping(value="/selectByConditions" ,method = RequestMethod.POST)
    @ResponseBody
    public  String selectByConditions(@RequestParam("userId") Long id,@RequestParam("userName") String name,@RequestParam("userPasswd") String passwd,@RequestParam("userAddr") String addr){
        User user=new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserPasswd(passwd);
        user.setUserAddr(addr);
        return userService.selectByConditions(user).toString();
    }


    @RequestMapping(value="/selectByList" ,method = RequestMethod.POST)
    @ResponseBody
    public String selectByList(@RequestBody List<Long> list){
        return userService.selectUserByList(list).toString();
    }


    @RequestMapping(value="/getByProperties" ,method = RequestMethod.GET)
    @ResponseBody
    public String getByProperties(@RequestParam("userId") Long id, @RequestParam("userName") String name, @RequestParam("userPasswd") String passwd,
                                      @RequestParam("userAddr") String addr){
        User user=new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserPasswd(passwd);
        user.setUserAddr(addr);
        List<User> list=userService.getByProperties(user);
        String str="";
        for(User u:list){
            str+= u.getUserId()+":"+u.getUserName()+"\n";
        }
        return str;
    }
}
