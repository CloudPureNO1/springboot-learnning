package com.springboot.learnning.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.learnning.mybatis.model.User;
import com.springboot.learnning.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.util.Base64;
import java.util.List;

import static javax.xml.crypto.dsig.Transform.BASE64;

/**
 * Created by CloudPure on 2018/1/25.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    @ResponseBody
    public String insert(){
        User user=new User();
        user.setUserId(12345L);
        user.setUserName("王沐曌");
        user.setUserPasswd(Base64.getEncoder().encodeToString("wangmz".getBytes()));
        user.setUserAddr("HangZhou");
        return userService.insert(user)+"";
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam("userid") Long id){
        return userService.delete(id)+"";
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public String update(Long id,String name,String passwd,String addr){
        return userService.update(id,name,passwd,addr)+"";
    }


    @RequestMapping(value="/select")
    @ResponseBody
    public String select(){
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(2,3);
        List<User> list=userService.select();
        for(User u:list){
            System.out.println(">>>>>>>>"+u.toString());
        }
        return list.toString();

    }



    @RequestMapping(value="/selectByName",method = RequestMethod.POST)
    @ResponseBody
    public String selectByName(@RequestParam("username") String name){
        return userService.selectByName(name).toString();
    }
}
