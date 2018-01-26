package com.springboot.learnning.junit;


import net.sf.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnningJunitWebApplication.class)
public class LearnningJunitWebApplicationTests {
	//注入webApplicationContext
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	//设置mockMvc
	@Before
	public void setMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void contextLoads() {
		JSONArray ja=new JSONArray();
		List<Long> list=new ArrayList<Long>();
		list.add(13L);
		list.add(22L);
		list.add(1322L);


		String json =JSONArray.fromObject(list).toString();

System.out.println("<<<<<<<<<<<<<<<<<<"+json);



		try {
		 MvcResult result= mockMvc.perform(MockMvcRequestBuilders.post("/user/getByList")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(json)
            ).andReturn();
			System.out.println("***********************"+result.getResponse().getContentAsString());
			System.out.println("***********************"+result.getResponse().getStatus());
			System.out.println("***********************"+result.getResponse().toString());
			System.out.println("***********************++++++++++++++++++++++++++++++++++++++");


		mockMvc.perform(MockMvcRequestBuilders.post("/user/getByList")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(json)
            ).andExpect(MockMvcResultMatchers.status().isOk())
				 .andDo(MockMvcResultHandlers.print());


		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Test
	public void getList(){
		List<Long> list=new ArrayList<Long>();
		list.add(13L);
		list.add(22L);
		list.add(1322L);

		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/user/getByList")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(JSONArray.fromObject(list).toString())
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
