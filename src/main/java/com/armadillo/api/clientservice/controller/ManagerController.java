package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.ManagerDto;
import com.armadillo.api.clientservice.service.ManagerService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Manager Controller
 * ------------------
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
@RequestMapping(path = "/manager")
public class ManagerController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ManagerService managerService;

	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	protected ManagerController() {
	}


	/**
	 * find manager object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/managertype/RM
	public ManagerDto findManagerById(@PathVariable(value = "id") String id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findManagerById - Parameters [id=" + id+ "]");

		ManagerDto managerDto = managerService.getManagerById(id);
		return managerDto;
	}



	/**
	 * list managers
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/managertype/list 
	public List<ManagerDto> findAllManagers()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllManagers");
 
		List<ManagerDto> dtoList = managerService.getAllManagers();
		return dtoList;
	}   


	/**
	 * Create a manager
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/managertype
    //{
    //    "id": "alan",
    //    "password": "p1ug_3"
    //}
	public ManagerDto createManager(@RequestBody @Validated ManagerDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createManager - " + dto.toString()+ "]");
		
		ManagerDto managerDto = managerService.createManager(dto);
		return managerDto;
	}


	/**
	 * Update manager object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/managertype/alan
	public ManagerDto updateManager(@PathVariable(value = "id") String id, @RequestBody @Validated ManagerDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateManager - " + dto.toString()+ "]");
		
		ManagerDto managerDto = managerService.updateManager(id, dto);

		return managerDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleManagerServiceException(ApplicationException exception ) {
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
