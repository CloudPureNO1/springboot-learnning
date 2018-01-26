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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudPure on 2018/1/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=LearnningJunitWebApplication.class)
public class TestPostList {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;//构建mvc对象
    @Before
    public void setMockMvc(){
        //初始化MockMvc 对象
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testPostByList(){
        List<Long> list=new ArrayList<Long>();
        list.add(13L);
        list.add(22L);
        list.add(1322L);
        String json= JSONArray.fromObject(list).toString();

        String url="/user/getByList";//Controller中的映射路径
        //用MockMvcRequestBuilders 构建RequestBuilder,给mockMvc 调用
        RequestBuilder requestBuilder= MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(json);
        try {
            //直接去结果
           MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();

           System.out.println("******************************************");
           //可以在控制台打印相应的信息，
            mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
           System.out.println("******************************************");
           int status=mvcResult.getResponse().getStatus();
           String content=mvcResult.getResponse().getContentAsString();
           System.out.println(">>>>>>>>>>>status="+status);
           System.out.println(">>>>>>>>>>>content="+content);

  /*          Assert.assertTrue("正确",status==200);
            Assert.assertFalse("错误",status!=200);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
