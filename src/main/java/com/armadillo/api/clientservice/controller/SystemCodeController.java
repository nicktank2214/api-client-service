package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;


import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.SystemCodeDto;

import com.armadillo.api.clientservice.service.SystemCodeService;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;






/**
 * System Code Controller
 * 
 * - we use a SystemCodeDto to pass parameter to and from the REST calls
 * 
 */
@RestController
@RequestMapping(path = "/systemcode")
public class SystemCodeController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	SystemCodeService systemCodeService;

	@Autowired
	public SystemCodeController(SystemCodeService systemCodeService) {
		this.systemCodeService = systemCodeService;
	}
	protected SystemCodeController() {
	}


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/systemcode/1    
	public SystemCodeDto findSystemCodeById(@PathVariable(value = "id") int id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemCodeById - Parameters [id=" + id+ "]");

		SystemCodeDto dto = systemCodeService.getSystemCodeById(id);
		return dto;		
	}


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbytype")
	//<GET>http://localhost:8080/systemcode/findbytype?codetype=COMPANY_STATUS
	public List<SystemCodeDto> findSystemCodesByCodeType(
    		@RequestParam(value = "codetype") String type
    		)	 throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemCodesByCodeType - Parameters [codetype=" + type+ "]");

		List<SystemCodeDto> dtoList = systemCodeService.findByCodeType(type);
		return dtoList;
	}

	
	/**
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/systemcode/list
	public List<SystemCodeDto> getAllSystemCodes()  throws ApplicationException {
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getAllSystemCodes - Parameters []");
 
		List<SystemCodeDto> dtoList = systemCodeService.getAllSystemCodes();
		return dtoList;
	}   

	
    @RequestMapping(method = RequestMethod.GET, path = "/findbytypeandvalue")
    //<GET>http://localhost:8080/systemcode/findbytypeandvalue?codetype=COMPANY_STATUS&codevalue=ACTIVE
    public SystemCodeDto findSystemCodesByCodeTypeCodeValue(
    		@RequestParam(value = "codetype") String type, 
    		@RequestParam(value = "codevalue") String value
    		)  throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemCodesByCodeTypeCodeValue "+
				"- Parameters [type=" + type+
				", value=" + value+
				"]");
    	
        SystemCodeDto dto = systemCodeService.findByCodeTypeAndCodeValue(type, value);
        
        return dto;
    }
    




	

	
	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleCountryServiceException(ApplicationException exception ) {
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
