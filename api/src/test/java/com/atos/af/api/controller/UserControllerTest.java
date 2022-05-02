package com.atos.af.api.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atos.af.api.ApiApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Ignore
	@Test
	public void shouldFindUserById() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(UserController.URI + "1").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.userName").exists()).andExpect(jsonPath("$.userName").value("ATUS43425"))
				.andExpect(jsonPath("$.birthDay").value("1990-12-11"))
				.andExpect(jsonPath("$.countryOfResidence").value("France"))
				.andExpect(jsonPath("$.phoneNumber").value("0656456787"))
				.andExpect(jsonPath("$.gender").value("M"))
				.andExpect(jsonPath("$.*", hasSize(6))).andReturn();
	}

	@Test
	public void shouldSaveUser() throws Exception {
		
		String jsonUser = new JSONObject().put("userName","ATUS45655")
				.put("birthDay","1992-11-12")
				.put("countryOfResidence","France")
				.put("phoneNumber","0656456787")
				.put("gender","M").toString();
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(UserController.URI).contentType(MediaType.APPLICATION_JSON)
						.content(jsonUser)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.userName").exists())
				.andExpect(jsonPath("$.userName").value("ATUS45655"))
				.andExpect(jsonPath("$.birthDay").value("1992-11-12"))
				.andExpect(jsonPath("$.countryOfResidence").value("France"))
				.andExpect(jsonPath("$.phoneNumber").value("0656456787"))
				.andExpect(jsonPath("$.gender").value("M"))
				.andExpect(jsonPath("$.*", hasSize(6)))
				.andReturn();
	}

	
	 @Test
	 public void shouldVerifyInvalidUserArgument() throws Exception {
		 String jsonUser = new JSONObject()
				 .put("userName","ATUS45655")
				 .put("birthDay","1992-11-12")
			.put("countryOfResidence","Italie")
			.put("phoneNumber","0656456787")
			.put("gender","M").toString();
	this.mockMvc
			.perform(MockMvcRequestBuilders.post(UserController.URI).contentType(MediaType.APPLICATION_JSON)
					.content(jsonUser)
					.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
		 	.andExpect(status().isBadRequest())
	        .andExpect(jsonPath("$.message").value("Validation Failed"))
	        .andReturn();
	 }
	

}
