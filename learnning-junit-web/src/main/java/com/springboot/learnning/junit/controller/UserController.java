package com.springboot.learnning.junit.controller;

import com.springboot.learnning.junit.model.User;
import com.springboot.learnning.junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/26.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getByList")
    public String getUsers(@RequestBody  List<Long> list){
        List<User>listUsers=userService.getUserByList(list);
        for(User user:listUsers){
            System.out.println(">>>>>>>>>>>>>>>"+user.toString());
        }
        return listUsers.toString();
    }


    @RequestMapping(value="/getUserByArray",method = RequestMethod.POST)
    public String getUserByArray(@RequestBody Long [] array){
        List<User>listUsers=userService.getUserByArray(array);
        for(User user:listUsers){
            System.out.println(">>>>>>>>>>>>>>>"+user.toString());
        }
        return listUsers.toString();
    }



    @RequestMapping(value="/getUserByMap",method = RequestMethod.GET)
    public String getUserByMap(@RequestBody Map<String,Object> map){
        List<User>listUsers=userService.getUserByMap(map);
    /*    for(User user:listUsers){
            System.out.println(">>>>>>>>>>>>>>>"+user.toString());
        }*/
        return listUsers.toString();
    }

}
