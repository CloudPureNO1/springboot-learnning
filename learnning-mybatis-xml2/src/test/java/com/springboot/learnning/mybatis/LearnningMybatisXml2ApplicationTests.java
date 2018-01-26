package com.springboot.learnning.mybatis;

import com.springboot.learnning.mybatis.model.User;
import javafx.application.Application;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =LearnningMybatisXml2Application.class)//指定启动类

public class LearnningMybatisXml2ApplicationTests {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private MockMvc mockMvc;
   // private RestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    //get请求，连接中要写参数
    @Test
    public void get() throws Exception {
        Map<String,String> multiValueMap = new HashMap<>();
        multiValueMap.put("username","wangsm");//传值，但要在url上配置相应的参数
        User user = testRestTemplate.getForObject("http://localhost:8080/user/getByProperties?userName={username}",User.class,multiValueMap);
        System.out.println(user.toString());
        Assert.assertEquals(user,null);
    }

/*
    @Test
    public void test() throws Exception {
        String url = "http://localhost:8080/user/selectByList";
        List<Long>list=new ArrayList<Long>();
        list.add(13L);
        list.add(22L);
        list.add(1322L);


    }*/

}
