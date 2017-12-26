package com.springboot.learnning.controller;

import com.springboot.learnning.dao.mapping.Users;
import com.springboot.learnning.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CloudPure on 2017/12/25.
 */

@Controller
@RequestMapping(value="user")
public class UsersController {
    private static final Logger logger= Logger.getLogger(UsersController.class);
    @Autowired
    private UsersService usersService;



    @ResponseBody
    @RequestMapping(value="save")
    public String saveUsers(){
        int n=0;
        Users user=new Users();
        user.setUserid(1004);
        user.setUserName("wangsm4");
        user.setUserpasswd("epsoft4");
        int i=usersService.saveUsers(user);
        if(i>0)  n+=i;
        user=new Users();
        user.setUserid(1002);
        user.setUserName("wangsm1");
        user.setUserpasswd("epsoft1");
        i=usersService.saveUsers(user);
       if(i>0) n+=i;

        user=new Users();
        user.setUserid(1003);
        user.setUserName("wangsm2");
        user.setUserpasswd("epsoft2");
        i=usersService.saveUsers(user);
        if(i>0)  n+=i;

        if(n>0){
            logger.info("插入了"+n+"条记录！");
            return "插入了"+n+"条记录！";
        }
        logger.info("插入"+user.toString()+"失败！");
        return "插入"+user.toString()+"失败！";
    }


    @RequestMapping(value="getAll")
    @ResponseBody
    public String getUsers(){
        List<Users>list=usersService.getUsers();
        if(list!=null&&list.size()>0){
            logger.info("查询结果："+list.toString());
            return list.toString();
        }
        logger.info("没有记录！");
        return "没有记录！";
    }
}
