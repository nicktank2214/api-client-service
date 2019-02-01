package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


import com.armadillo.api.clientservice.dto.AccountDto;
import com.armadillo.api.clientservice.service.AccountService;
import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Account Controller
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
@RequestMapping(path = "/account")
public class AccountController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	protected AccountController() {
	}


	/**
	 * find account object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/account/A055    
	public AccountDto findAccountById(@PathVariable(value = "id") String id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAccountById - Parameters [id=" + id+ "]");

		AccountDto accountDto = accountService.getAccountById(id);
		return accountDto;
	}



	/**
	 * list accounts
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/account/list 
	public List<AccountDto> findAllAccounts()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllAccounts");
 
		List<AccountDto> dtoList = accountService.getAllAccounts();
		return dtoList;
	}   


	/**
	 * list accounts using different operators
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/search1")    
	//<GET>http://localhost:8080/account/search1?val=RBS&opr=Like
	public List<AccountDto> accountSearch1(
			@RequestParam(value = "val") String searchValue,
			@RequestParam(value = "opr") String searchOperator
			)  throws ApplicationException {		

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" accountSearch1 - Parameters ["
				+"searchValue=" + searchValue +", "+"searchOperator=" + searchOperator
				+ "]");

		List<AccountDto> dtoList = null;
		if (searchOperator.equals("Account")) {
			dtoList = accountService.findAccountsByAccount(searchValue);			
		}
		if (searchOperator.equals("Company")) {
			dtoList = accountService.findAccountsByCompany(searchValue);			
		}		
		if (searchOperator.equals("ALL")) {
			dtoList = accountService.getAllAccounts();			
		}

		return dtoList;
	}   
	
	
	/**
	 * Create a account
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/account
    //{
    //    "account": "H596",
    //    "partner": "",
    //    "sales_id": "",
    //    "card_type": "",
    //    "card_number": "",
    //    "card_validfrom": null,
    //    "card_expiry": null,
    //    "switch_number": "0",
    //    "cardholder_name": "",
    //    "save_card": "",
    //    "billing_company": "H.V Skan Ltd",
    //    "billing_telephone": "0121 733 3003",
    //    "billing_fax": "",
    //    "billing_addr1": "425-433 Stratford Road",
    //    "billing_addr2": "Shirley",
    //    "billing_town": "Solihull",
    //    "billing_county": "West Midlands",
    //    "billing_country": "UK",
    //    "billing_postcode": "B90 4AE",
    //    "billing_contact": "Mr Chris Jacob",
    //    "billing_email": "chj@skan.co.uk",
    //    "billing_email_cc": "pauline@skan.co.uk",
    //    "invoice_period": "weekly",
    //    "payment_type": "inv",
    //    "vat_number": "",
    //    "vat_exempt": "T1",
    //    "price_band": 8,
    //    "good_customer": "no",
    //    "international_discountpercent": 0,
    //    "companieshouse_discountpercent": 0,
    //    "invoice_method": "email"
    //}
	public AccountDto createAccount(@RequestBody @Validated AccountDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createAccount - " + dto.toString()+ "]");
		
		AccountDto accountDto = accountService.createAccount(dto);
		return accountDto;
	}


	/**
	 * Update account object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/account/330    
	public AccountDto updateAccount(@PathVariable(value = "id") String id, @RequestBody @Validated AccountDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateAccount - " + dto.toString()+ "]");
		
		AccountDto accountDto = accountService.updateAccount(id, dto);

		return accountDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleAccountServiceException(ApplicationException exception ) {
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
