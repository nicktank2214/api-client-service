package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;


import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.AccountCodeDto;

import com.armadillo.api.clientservice.service.AccountCodeService;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;






/**
 * Account Code Controller
 * 
 * - we use a AccountCodeDto to pass parameter to and from the REST calls
 * 
 */
@RestController
@RequestMapping(path = "/accountcode")
public class AccountCodeController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());


	AccountCodeService accountCodeService;

	@Autowired
	public AccountCodeController(AccountCodeService accountCodeService) {
		this.accountCodeService = accountCodeService;
	}
	protected AccountCodeController() {
	}


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/accountcode/1    
	public AccountCodeDto findAccountCodeById(@PathVariable(value = "id") int id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAccountCodeById - Parameters [id=" + id+ "]");

		AccountCodeDto dto = accountCodeService.getAccountCodeById(id);
		return dto;		
	}


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbytype")
	//<GET>http://localhost:8080/accountcode/findbyaccount?account=A055
	public List<AccountCodeDto> findAccountCodesByAccount(
    		@RequestParam(value = "account") String account
    		)	 throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAccountCodesByCodeType - Parameters [account=" + account+ "]");

		List<AccountCodeDto> dtoList = accountCodeService.findByAccount(account);
		return dtoList;
	}

	
	/**
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/accountcode/list
	public List<AccountCodeDto> getAllAccountCodes()  throws ApplicationException {
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getAllAccountCodes - Parameters []");
 
		List<AccountCodeDto> dtoList = accountCodeService.getAllAccountCodes();
		return dtoList;
	}   

	
    @RequestMapping(method = RequestMethod.GET, path = "/findbyaccountandtypeandvalue")
    //<GET>http://localhost:8080/accountcode/findbyaccountandtypeandvalue?account=A055&codetype=COMPANY_STATUS&codevalue=ACTIVE
    public AccountCodeDto findAccountCodeByAccountCodeTypeCodeValue(
    		@RequestParam(value = "account") String account,     		
    		@RequestParam(value = "codetype") String type, 
    		@RequestParam(value = "codevalue") String value
    		)  throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAccountCodesByCodeTypeCodeValue "+
				"- Parameters [type=" + type+
				", value=" + value+
				"]");
    	
        AccountCodeDto dto = accountCodeService.findByAccountAndCodeTypeAndCodeValue(account, type, value);
        
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
