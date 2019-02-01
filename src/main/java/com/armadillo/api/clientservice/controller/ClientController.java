package com.armadillo.api.clientservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.armadillo.api.clientservice.dto.ClientDto;
import com.armadillo.api.clientservice.service.ClientService;

import com.armadillo.api.exception.ExceptionResponse;
import com.armadillo.api.exception.ApplicationException;






/**
 * Client Controller
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
@RequestMapping(path = "/client")
public class ClientController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());




	ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	protected ClientController() {
	}


	/**
	 * find client object 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	//<GET>http://localhost:8080/client/660099   
	public ClientDto findClientById(@PathVariable(value = "id") int id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findClientById - Parameters [id=" + id+ "]");

		ClientDto clientDto = clientService.getClientById(id);
		return clientDto;
	}



	/**
	 * list clients
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/list")    
	//<GET>http://localhost:8080/client/list 
	public List<ClientDto> findAllClients()  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findAllClients");
 
		List<ClientDto> dtoList = clientService.getAllClients();
		return dtoList;
	}   


	/**
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/findbyaccount/{id}")
	//<GET>http://localhost:8080/client/findbyaccount/A055  
	public List<ClientDto> findClientsByAccount(@PathVariable(value = "id") String id) throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findClientsByAccount - Parameters [id=" + id+ "]");
 
		List<ClientDto> dtoList = clientService.findClientsByAccount(id); 
		return dtoList;
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/findbyclientandaccount")
    public ClientDto findClientByClientAccount(
    		@RequestParam(value = "client") Integer client, 
    		@RequestParam(value = "account") String account
    		)  throws ApplicationException {
    	
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findClientByClientAndAccount "+
				"- Parameters [client=" + client+
				", account=" + account+
				"]");
    	
        ClientDto dto = clientService.findClientByClientAccount(client, account); 
        return dto;
    }
    

	/**
	 * list clients by name using different operators
	 */   
	@RequestMapping(method = RequestMethod.GET, path = "/search1")    
	//<GET>http://localhost:8080/client/search1?val=RBS&opr=Like
	public List<ClientDto> clientSearch1(
			@RequestParam(value = "val") String searchValue,
			@RequestParam(value = "opr") String searchOperator
			)  throws ApplicationException {		

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" clientSearch - Parameters ["
				+"searchValue=" + searchValue +", "+"searchOperator=" + searchOperator
				+ "]");

		List<ClientDto> dtoList = null;
		if (searchOperator.equals("Account")) {
			dtoList = clientService.findClientsByAccount(searchValue);			
		}
		if (searchOperator.equals("Client")) {
			dtoList = clientService.findClientsByClient(new Integer(searchValue));			
		}

		return dtoList;
	}   
	
	
	/**
	 * Create a client
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	//<POST>http://localhost:8080/client
    //{
    //	"client": 662373,
    //	"password": "133640",
    //	"account": "W703",
    //	"group_id": 0,
    //	"email": "charlotte@middletonpartners.co.uk",
    //	"title": "",
    //	"forename": "Sharon",
    //	"surname": "Harding",
    //	"addr1": "The Hall",
    //	"addr2": "4 New Street",
    //	"town": "Salisbury",
    //	"county": "Wilts",
    //	"country": "",
    //	"postcode": "SP1 2PH",
    //	"company": "Middleton Partners",
    //	"telephone": "01722 432600",
    //	"fax": "01722 432654",
    //	"cardholder_name": "",
    //	"save_card": "",
    //	"contact": "Ms Margaret Williamson]",
    //	"ch_monthfeedue": 0,
    //	"ch_paid": "yes",
    //	"ch_user": "yes"
    //}
	public ClientDto createClient(@RequestBody @Validated ClientDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" createClient - " + dto.toString()+ "]");
		
		ClientDto clientDto = clientService.createClient(dto);
		return clientDto;
	}


	/**
	 * Update client object using POST - updates all fields
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/{id}")
	//<POST>http://localhost:8080/client/662373    
	public ClientDto updateClient(@PathVariable(value = "id") int id, @RequestBody @Validated ClientDto dto)  throws ApplicationException {

		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" updateClient - " + dto.toString()+ "]");
		
		ClientDto clientDto = clientService.updateClient(id, dto);

		return clientDto;
	}




	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleClientServiceException(ApplicationException exception ) {
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
