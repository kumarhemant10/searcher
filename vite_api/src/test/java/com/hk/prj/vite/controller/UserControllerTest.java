package com.hk.prj.vite.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.hk.prj.vite.AbstractTest;
import com.hk.prj.vite.constant.UrlConstants;
import com.hk.prj.vite.dto.UserDTO;

public class UserControllerTest extends AbstractTest{

	@Test
	public void getAllUserTestUnauthorized() throws Exception {
		mvc.perform(get(UrlConstants.USERS))
		.andDo(print())
		.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void getAllUserTest() throws Exception {
		String authorization = getAuthorizationAdmin(); 				
		mvc.perform(get(UrlConstants.USERS).header("Authorization", authorization))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("hemant")));
	}
	
	@Test
	public void createNewUserTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("test1");
		userDTO.setPassword("test1");
		userDTO.setEmail("test1@mail.com");
		
		String authorization = getAuthorizationAdmin(); 
		
		mvc.perform(
				post(UrlConstants.USERS)
				.header("Authorization", authorization)
				.content(mapToJson(userDTO))
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(content().string(containsString("test1")));
	}
}
