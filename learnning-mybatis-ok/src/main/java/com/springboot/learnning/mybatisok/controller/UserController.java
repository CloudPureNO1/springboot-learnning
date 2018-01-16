package com.springboot.learnning.mybatisok.controller;

import com.springboot.learnning.mybatisok.model.User;
import com.springboot.learnning.mybatisok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/16.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
private UserService userService;

    @RequestMapping(value="/insert")
    @ResponseBody
    public String insert(){
        User user=new User();
        user.setUserid(1001L);
        user.setPasswd("wangsm");
        user.setUsername("王沐毅");
        user.setAddr("杭州西湖");
        int i=userService.insert(user);
        return "成功插入了"+i+"条数据！";
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(){
        User user=new User();
        user.setUserid(1001L);
        int i=userService.delete(user);
        return "成功删除了"+i+"条记录！";
    }

    @RequestMapping(value="/findByName")
    @ResponseBody
    public String findByName(@RequestParam("username") String username){

        List<User>list=userService.findByName(username);
        String str=list==null?null:list.size()<1?null:list.toString();
        return "username="+username+";"+str;
    }

    @RequestMapping(value="/find/{name}/{id}")
    @ResponseBody
    public String findAll(@PathVariable("id") String id,@PathVariable("name") String name){
        List<User>list=userService.findAll();
        String str=list==null?null:list.size()<1?null:list.toString();;
        return "id="+id+";name="+name+";"+str;
    }
}
