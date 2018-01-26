package com.springboot.learnning.junit;

import com.springboot.learnning.junit.controller.UserController;
import net.sf.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnningJunitWebApplication.class)
public class MyJunitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

   private MockMvc mockMvc;//模拟mvc对象类

    @Before
    public void setMockMvc(){
      //mockMvc=  MockMvcBuilders.standaloneSetup(new UserController()).build();//一般不用
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

@Test
    public void testByList(){
Assert.assertEquals("hah",2,2);
        try {
            List<Long> list=new ArrayList<Long>();
            list.add(22L);
            list.add(13L);
            list.add(1322L);
            String json=JSONArray.fromObject(list).toString();
            String url="/user/getByList";
            RequestBuilder requestBuilder= MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(json);
           MvcResult mvcResult= mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();


            int status = mvcResult.getResponse().getStatus();
            String content = mvcResult.getResponse().getContentAsString();

            Assert.assertEquals("正确",200,status);

            Assert.assertFalse("错误",status!=200);
            System.out.println("返回结果："+status);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
