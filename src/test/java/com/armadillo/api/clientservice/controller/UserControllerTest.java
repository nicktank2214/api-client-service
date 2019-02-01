/**
 * 
 */
package com.armadillo.api.clientservice.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.armadillo.api.clientservice.ClientServiceApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientServiceApplication.class)
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@InjectMocks
	UserController userController = new UserController();

	@Before
	public void setup() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
				//.apply(springSecurity())
				;
		this.mockMvc = builder.build();
	}

	@Test
	public void testFindAllUsersStatusOK() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8303/user/list")).andExpect(status().isOk());
	}

	@Test
	public void testFindAllUsersReturnInJson () throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8303/user/list").header("Accept", "application/json"))
				.andExpect(content().contentType("application/json; charset=UTF-8"));
	}

	@Test
	public void testFindUserByIdWithCorrectUsername() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8303/user/22"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.user_name", CoreMatchers.is("nicktank")))				
				.andDo(print());
	}

	@Test
	public void testFindUserByIdWithWrongId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8303/user/9999"))
		.andExpect(jsonPath("$.message_code", CoreMatchers.is("001")))
		.andDo(print());
	}
	
	@Test
	public void testCreateUserStatusCreated() throws Exception {
		
		//{
		//	"password": "password",
		//	"user_name": "nicktank3",
		//	"first_name": "nick",
		//	"last_name": "tankard",
		//	"role_id": "0",
		//	"department_id": "0",
		//	"disabled_flag": "0",
		//	"active_flag": "1"
		//}   
		String user_name = "user_"+new Date().getTime();
		String exampleUserJson = 
				"{\"password\":\"password\",\"user_name\":\""+user_name+"\",\"first_name\":\"nick\","+
						"\"last_name\":\"tankard\",\"role_id\":\"0\",\"department_id\":\"0\",\"disabled_flag\":\"0\","+
						"\"active_flag\":\"1\""+		    
						"}"; 
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("http://localhost:8303/user")
					.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isCreated())
				.andDo(print());
	}

	@Test
	public void testCreateUserStatusError() throws Exception {
		
		//{
		//	"password": "password",
		//	"user_name": "nicktank",
		//	"first_name": "nick",
		//	"last_name": "tankard",
		//	"role_id": "0",
		//	"department_id": "0",
		//	"disabled_flag": "0",
		//	"active_flag": "1"
		//}   
		String exampleUserJson = 
				"{\"password\":\"password\",\"user_name\":\"nicktank\",\"first_name\":\"nick\","+
						"\"last_name\":\"tankard\",\"role_id\":\"0\",\"department_id\":\"0\",\"disabled_flag\":\"0\","+
						"\"active_flag\":\"1\""+		    
						"}"; 
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("http://localhost:8303/user")
					.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(jsonPath("$.message_code", CoreMatchers.is("002")))
				.andDo(print());
	}


	@Test
	public void testUpdateUserStatusOk() throws Exception {
		String first_name = "firstname_"+new Date().getTime();
		String exampleUserJson = 
				"{\"password\":\"password\",\"user_name\":\"nicktank\",\""+first_name+"\":\"nick\","+
						"\"last_name\":\"tankard\",\"role_id\":\"0\",\"department_id\":\"0\",\"disabled_flag\":\"0\","+
						"\"active_flag\":\"1\""+		    
						"}"; 
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("http://localhost:8303/user/22")
					.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	
	
}
