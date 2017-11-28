package com.springboot.learnning.thymeleaf2.controller;

import com.springboot.learnning.thymeleaf2.domain.LearnningResourse;
import com.springboot.learnning.thymeleaf2.domain.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2017/11/28.
 */
@Controller
public class LoginController {
    private static final Logger logger= Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object>map=new HashMap<String,Object>();
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if(!StringUtils.isEmptyOrWhitespace(username)&&!StringUtils.isEmptyOrWhitespace(password)){
            User user=new User(username,password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        logger.info("*********ajax json login****************");
        return map;
    }

    @RequestMapping(value="/msg")
    public ModelAndView showMsg(){
        List<LearnningResourse> listResourse=new ArrayList<LearnningResourse>();
        LearnningResourse resourse=new LearnningResourse();
        resourse.setResourseName("Spring Boot");
        resourse.setResourseOwner("Spring Boot 官网");
        resourse.setResourseURL("http://projects.spring.io/spring-boot/");
        resourse.setResourseDesc("Takes an opinionated view of building production-ready Spring applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible.");
        listResourse.add(resourse);

        resourse=new LearnningResourse();
        resourse.setResourseName("GitHub");
        resourse.setResourseOwner("GitHub 官网");
        resourse.setResourseURL("http://github.com/");
        resourse.setResourseDesc("GitHub is a code hosting platform for version control and collaboration. It lets you and others work together on projects from anywhere.\n" +
                "\n" +
                "This tutorial teaches you GitHub essentials like repositories, branches, commits, and Pull Requests. You’ll create your own Hello World repository and learn GitHub’s Pull Request workflow, a popular way to create and review code.");
        listResourse.add(resourse);

        ModelAndView modelAndView=new ModelAndView("showMsg");
        modelAndView.addObject("listResourse",listResourse);

        logger.info("**********loginOk,show Message!**********************");
        return modelAndView;
    }
}
