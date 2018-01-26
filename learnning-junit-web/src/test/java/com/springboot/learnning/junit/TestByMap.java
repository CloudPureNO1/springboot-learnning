package com.springboot.learnning.junit;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnningJunitWebApplication.class)
public class TestByMap {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;//用MockMvc 构建mvc对象

    //初始化mockMvc
    @Before
    public void setMockMvc(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testByMap(){
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("userName","王沁之");
        List<Long>list=new ArrayList<Long>();
        list.add(13L);
        list.add(22L);
        list.add(1322L);
        map.put("ids",list);
       // String json= JSONArray.fromObject(map).toString();
        String json= JSONObject.fromObject(map).toString();
        String url="/user/getUserByMap";
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(json);
        try {
            MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
            int status=mvcResult.getResponse().getStatus();;
            String content=mvcResult.getResponse().getContentAsString();

            System.out.println(">>>>>>>>>>>>>status="+status);
            System.out.println(">>>>>>>>>>>>>content"+content);

            Assert.assertTrue("正确",status==200);
            Assert.assertFalse("错误",status!=200);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

