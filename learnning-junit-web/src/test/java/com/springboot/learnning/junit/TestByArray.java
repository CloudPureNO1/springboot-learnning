package com.springboot.learnning.junit;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by CloudPure on 2018/1/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnningJunitWebApplication.class)
public class TestByArray {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;//构建模拟的mvc对象

    //初始化mockMvc对象
    @Before
    public void setMockMvc(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testByArray(){
        try {
            Long []array={13L,22L,1322L};
            String json= JSONArray.fromObject(array).toString();
            String url="/user/getUserByArray";
            RequestBuilder requestBuilder= MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(json);
            MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
            int status=mvcResult.getResponse().getStatus();
            String content=mvcResult.getResponse().getContentAsString();
            System.out.println(">>>>>>>>status="+status);
            System.out.println(">>>>>>>>content="+content);


            //mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());



            Assert.assertTrue("正确",status==200);
            Assert.assertFalse("错误",status!=200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
