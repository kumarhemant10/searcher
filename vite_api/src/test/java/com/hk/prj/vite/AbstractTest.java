package com.hk.prj.vite;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.prj.vite.security.JwtConfig;
import com.hk.prj.vite.security.LoginBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public abstract class AbstractTest {

	@Autowired protected MockMvc mvc;

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Autowired JwtConfig jwtConfig;
	
	protected String getAuthorizationAdmin() throws JsonProcessingException, Exception {
		String authorization =null;
		LoginBean user = new LoginBean();
		user.setUsername("hemant");
		user.setPassword("hemant");
		MvcResult mvcResult = mvc.perform(post(jwtConfig.getUri()).content(mapToJson(user))).andExpect(status().isOk()).andReturn();
		authorization = mvcResult.getResponse().getHeader("Authorization");
		return authorization;
	}


}
