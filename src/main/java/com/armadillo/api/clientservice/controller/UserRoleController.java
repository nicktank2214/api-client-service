package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.armadillo.api.clientservice.dto.UserRoleDto;
import com.armadillo.api.clientservice.service.UserRoleService;
import com.armadillo.api.exception.ExceptionResponse;

import com.armadillo.api.exception.ApplicationException;








/**
 * User Role Controller
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
@RequestMapping(path = "/userrole")
public class UserRoleController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	UserRoleService userRoleService;

	@Autowired
	public UserRoleController(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	protected UserRoleController() {
	}


	/**
	 * find object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/userrole/1    
	public UserRoleDto findUserRoleById(@PathVariable(value = "id") int id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findUserRoleById - Parameters [id=" + id+ "]");

		UserRoleDto userDto = userRoleService.getUserRoleById(id);
		return userDto;
	}


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyuserid/{id}")
	//<GET>http://localhost:8080/userrole/findbyuserid/1   
	public List<UserRoleDto> findUserRolesByUserId(@PathVariable(value = "id") int id) {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findUserRolesByUserId - Parameters [id=" + id+ "]");
 
		List<UserRoleDto> dtoList = userRoleService.findUserRolesByUserId(id); 

		return dtoList;
	}

	
	/**
	 * list all
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/userrole/list 
	public List<UserRoleDto> findAllUserRoles()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllUserRoles - Parameters []");
 
		List<UserRoleDto> dtoList = userRoleService.getAllUsers();
		return dtoList;
	}   


	/**
	 * Create a user
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/userrole
	//{
	//	"user_id": 1,
	//	"role": "ADMIN"
	//}     
	public UserRoleDto createUser(@RequestBody @Validated UserRoleDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createUserRole - " + dto.toString()+ "]");
		
		UserRoleDto userDto = userRoleService.createUserRole(dto);
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
