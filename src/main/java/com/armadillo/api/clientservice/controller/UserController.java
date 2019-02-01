package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.UserDto;
import com.armadillo.api.clientservice.service.UserService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;








/**
 * User Controller
 * ---------------
 * 
 * Keep your @Controller’s clean and focused - 
 * Controllers are supposed to be very thin. 
 * You want Controllers to coordinate and delegate, rather than to execute actual business logic. Here are the key practices:
 * 
 * Controllers should be stateless! Controllers are by default singletons and giving them any state can cause massive issues.
 * Controllers should not execute business logic but rely on delegation.
 * Controllers should deal with the HTTP layer of the application. This should not be passed down to Services.
 * Controllers should be oriented around a use-case / business-capability.
 * 
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	protected UserController() {
	}


	/**
	 * find user object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/user/1    
	public UserDto findUserById(@PathVariable(value = "id") int id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findUserById - Parameters [id=" + id+ "]");

		UserDto userDto = userService.getUserById(id);
		return userDto;
	}


	/**
	 * find user object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyusername")
	//<GET>http://localhost:8080/user/findbyusername?username=NICK   
	public UserDto findUserByUserName(
    		@RequestParam(value = "username") String name
			)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findUserByUserName - Parameters [name=" + name+ "]");

		UserDto userDto = userService.getUserByUserName(name);
		return userDto;
	}


	/**
	 * list users
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/user/list 
	public List<UserDto> findAllUsers()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllUsers - Parameters []");
 
		List<UserDto> dtoList = userService.getAllUsers();
		return dtoList;
	}   


	/**
	 * Create a user
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/user
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
	public UserDto createUser(@RequestBody @Validated UserDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createUser - " + dto.toString()+ "]");
		
		UserDto userDto = userService.createUser(dto);
		return userDto;
	}


	/**
	 * Update user object using PUT - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/user/330
	//{
	//	"password": "password",
	//	"user_name": "nicktank",
	//	"first_name": "nick",
	//	"last_name": "tankard",
	//	"role_id": "0",
	//	"department_id": "0",
	//	"disabled_flag": "0",
	//	"active_flag": "1",
	//}      
	public UserDto updateWithPost(@PathVariable(value = "id") int id, @RequestBody @Validated UserDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createUser - " + dto.toString()+ "]");
		
		UserDto userDto = userService.updateUser(id, dto);

		return userDto;
	}




/*	*//**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *//*
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();
	}*/

	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleUserServiceException(ApplicationException exception ) {
		return exception.getExceptionResponse();
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(Exception exception) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), 
				exception.getMessage(),  
				"ERROR"
				);		
		
		return exceptionResponse;
	}
	
	
}
