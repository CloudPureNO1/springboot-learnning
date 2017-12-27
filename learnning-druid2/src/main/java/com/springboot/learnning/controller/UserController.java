package com.springboot.learnning.controller;

import com.springboot.learnning.dao.entity.User;
import com.springboot.learnning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Controller
@RequestMapping(value="user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="all")
    @ResponseBody
    public String getAll(){
        List<User>list=userService.getAll();
        if(list!=null&&list.size()>0) return list.toString();
        return null;
    }
}
