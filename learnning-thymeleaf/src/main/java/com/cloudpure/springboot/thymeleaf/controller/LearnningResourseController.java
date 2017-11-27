package com.cloudpure.springboot.thymeleaf.controller;


import com.cloudpure.springboot.thymeleaf.Bean.LearnningResourse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/learn")
public class LearnningResourseController {
    private static final Logger logger= Logger.getLogger(LearnningResourse.class);
    @Value("${application.msg}")
    private String ms;

    @RequestMapping(value="/listResource",method = RequestMethod.GET)
    public ModelAndView showResourse(){

        List<LearnningResourse>listResourse=new ArrayList<LearnningResourse>();
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

        ModelAndView modelAndView=new ModelAndView("/learnningResourse");
        modelAndView.addObject("listResourse",listResourse);

       logger.info("**************** listResourse.get(0).toString()*******************");
        return modelAndView;
    }
}
