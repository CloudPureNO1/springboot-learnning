package com.springboot.learnning.mybatis2.controller;

import com.github.pagehelper.PageHelper;
import com.springboot.learnning.mybatis2.model.User;
import com.springboot.learnning.mybatis2.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    private static final Logger logger= Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/addUser/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@PathVariable("id") Long id, @RequestParam("userName") String userName){
        User user=new User();
        user.setUserId(Long.valueOf(1000+id));
        user.setUserName(userName+id);
        user.setUserPasswd(Base64.getEncoder().encodeToString((userName+id).getBytes()));
        user.setUserAddr("HangZhou"+id);
        return userService.save(user)+"";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestParam("id") Long id,@RequestParam("userName") String userName){
        User user=userService.getUserById(id);
        user.setUserName(userName);
        return userService.update(user)+"";
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(@RequestParam("id") Long id){
        return userService.delete(id)+"";
    }

    @RequestMapping(value="/all")
    @ResponseBody
    public String getAll(){
        List<User> list=userService.getAll();
        for(User user:list){
            logger.info("*******"+user.toString());
        }
        PageHelper.startPage(2,2);
        list=userService.getAll();
        for(User user:list){
            logger.info(">>>>>>>>>>>>>>>>>>>"+user.toString());
        }
        return list.toString();
    }

    @RequestMapping(value="/updateUser",method=RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("passwd") String passwd){
        logger.info(">>>>>>>>>>>>>id="+id+";name="+name+";passwd="+passwd);
        return userService.updateUser(id,name,passwd)+"";
    }
}
