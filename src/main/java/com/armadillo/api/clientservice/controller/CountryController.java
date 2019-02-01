package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.CountryDto;
import com.armadillo.api.clientservice.service.CountryService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Country Controller
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
@RequestMapping(path = "/country")
public class CountryController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	protected CountryController() {
	}


	/**
	 * find country object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/countrytype/RM
	public CountryDto findCountryById(@PathVariable(value = "id") Integer id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findCountryById - Parameters [id=" + id+ "]");

		CountryDto countryDto = countryService.getCountryById(id);
		return countryDto;
	}


	/**
	 * find country object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbycountrycode/{id}")
	//<GET>http://localhost:8080/countrytype
	public CountryDto findCountryByCountryCode(
			@PathVariable(value = "id") String id 
			) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findCountryByCountryCode - Parameters [id=" + id+ "]");

		CountryDto countryDto = countryService.getCountryByCountryCode(id);
		return countryDto;
	}

	
	/**
	 * list countrys
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/countrytype/list 
	public List<CountryDto> findAllCountrys()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllCountrys");
 
		List<CountryDto> dtoList = countryService.getAllCountrys();
		return dtoList;
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
