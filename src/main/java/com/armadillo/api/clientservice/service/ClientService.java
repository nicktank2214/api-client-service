package com.armadillo.api.clientservice.service;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;
import com.armadillo.api.clientservice.domain.Client;
import com.armadillo.api.clientservice.dto.ClientDto;
import com.armadillo.api.clientservice.repository.ClientRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Client Service
 * --------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ClientService {


	//inject repositories
	private ClientRepository clientRepository;



	//constructor
	@Autowired 
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;	
	}

	
	/**
	 *
	 */ 
	public ClientDto getClientById(Integer id)  throws ApplicationException {
		Client client = null;
		client = this.verifyClient(id);
		return toDto(client);
	}    


	/**
	 *
	 */ 
	public ClientDto findClientByClientAccount(Integer id, String account)  throws ApplicationException {
		Client obj = null;
		obj = this.verifyClientAndAccount(id, account);

		return toDto(obj);
	}   
	
	
	/**
	 * 
	 */   
	public List<ClientDto> getAllClients()  throws ApplicationException {
		Iterable<Client> listIterable = clientRepository.findAll();
		List<ClientDto> dtoList =
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_client -> toDto(_client))
				.collect(Collectors.toList());    
		return dtoList;
	}  

	
	public List<ClientDto> findClientsByAccount(String account)  throws ApplicationException {
		Iterable<Client> listIterable = clientRepository.findByAccount(account);
		List<ClientDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_client -> toDto(_client))
				.collect(Collectors.toList());    
		return dtoList;
	}
	

	public List<ClientDto> findClientsByClient(Integer client) throws ApplicationException {
		Iterable<Client> listIterable = clientRepository.findByClient(client);
		List<ClientDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_client -> toDto(_client))
				.collect(Collectors.toList());    
		return dtoList;
	}
	
	
	/**
	 * Create a client
	 */
	public ClientDto createClient(ClientDto dto)  throws ApplicationException {
		
		Client clientExists = null;
		try {clientExists=clientRepository.findById(dto.getClient()).get();}catch(Exception e) {}
		if (clientExists!=null) {	
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getClient(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getClient(), exceptionResponse);
		}
		
		Client newClient = new Client( 
				dto.getClient(),			
				dto.getPassword(),			
				dto.getAccount(),			
				dto.getGroupId(),			
				dto.getEmail(),			
				dto.getTitle(),			
				dto.getForename(),			
				dto.getSurname(),			
				dto.getAddr1(),			
				dto.getAddr2(),			
				dto.getTown(),			
				dto.getCounty(),			
				dto.getCountry(),			
				dto.getPostcode(),			
				dto.getCompany(),			
				dto.getTelephone(),			
				dto.getFax(),			
				dto.getCardholderName(),			
				dto.getSaveCard(),			
				dto.getContact(),			
				dto.getChMonthfeedue(),			
				dto.getChPaid(),			
				dto.getChUser()
				);
		
		validate(newClient);

		Client client = clientRepository.save(newClient);
	
		//TODO: COPY CLIENT PRODUCTS
		
		return toDto(client);
	}


	/**
	 * Update client
	 */    
	public ClientDto updateClient(Integer id, ClientDto dto)  throws ApplicationException {
		Client client = null;
		client = this.verifyClient(id);

		if (dto.getPassword()!=null) {		
			client.setPassword(dto.getPassword());
		}
		if (dto.getAccount()!=null) {		
			client.setAccount(dto.getAccount());
		}		
		if (dto.getGroupId()!=null) {		
			client.setGroupId(dto.getGroupId());
		}	
		if (dto.getEmail()!=null) {		
			client.setEmail(dto.getEmail());
		}	
		if (dto.getTitle()!=null) {		
			client.setTitle(dto.getTitle());
		}	
		if (dto.getForename()!=null) {		
			client.setForename(dto.getForename());
		}			
		if (dto.getSurname()!=null) {		
			client.setSurname(dto.getSurname());
		}	
		if (dto.getAddr1()!=null) {		
			client.setAddr1(dto.getAddr1());
		}	
		if (dto.getAddr2()!=null) {		
			client.setAddr2(dto.getAddr2());
		}	
		if (dto.getTown()!=null) {		
			client.setTown(dto.getTown());
		}
		if (dto.getCounty()!=null) {		
			client.setCounty(dto.getCounty());
		}
		if (dto.getCountry()!=null) {		
			client.setCountry(dto.getCountry());
		}
		if (dto.getPostcode()!=null) {		
			client.setPostcode(dto.getPostcode());
		}
		if (dto.getCompany()!=null) {		
			client.setCompany(dto.getCompany());
		}		
		if (dto.getTelephone()!=null) {		
			client.setTelephone(dto.getTelephone());
		}	
		if (dto.getFax()!=null) {		
			client.setFax(dto.getFax());
		}	
		if (dto.getCardholderName()!=null) {		
			client.setCardholderName(dto.getCardholderName());
		}	
		if (dto.getSaveCard()!=null) {		
			client.setSaveCard(dto.getSaveCard());
		}	
		if (dto.getContact()!=null) {		
			client.setContact(dto.getContact());
		}
		if (dto.getChMonthfeedue()!=null) {		
			client.setChMonthfeedue(dto.getChMonthfeedue());
		}
		if (dto.getChPaid()!=null) {		
			client.setChPaid(dto.getChPaid());
		}
		if (dto.getChUser()!=null) {		
			client.setChUser(dto.getChUser());
		}		
						
			
		validate(client);

		return toDto(clientRepository.save(client));
	} 



	/**
	 * Convert the client entity to a ClientDto
	 */
	private ClientDto toDto(Client client) {  
		ClientDto dto = new ClientDto(
				client.getClient(),			
				client.getPassword(),			
				client.getAccount(),			
				client.getGroupId(),			
				client.getEmail(),			
				client.getTitle(),			
				client.getForename(),			
				client.getSurname(),			
				client.getAddr1(),			
				client.getAddr2(),			
				client.getTown(),			
				client.getCounty(),			
				client.getCountry(),			
				client.getPostcode(),			
				client.getCompany(),			
				client.getTelephone(),			
				client.getFax(),			
				client.getCardholderName(),			
				client.getSaveCard(),			
				client.getContact(),			
				client.getChMonthfeedue(),			
				client.getChPaid(),			
				client.getChUser(),
				""//action
				);

		return dto;
	}




	/**
	 * Verify and return the Client given an id.
	 */
	private Client verifyClient(int id) throws ApplicationException {
		Client obj= clientRepository.findById(id).get();
		if (obj==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return obj;
	}


	/**
	 * Verify and return the Client given an id.
	 */
	private Client verifyClientAndAccount(Integer id, String account) throws ApplicationException {
		Client obj= clientRepository.findByClientAndAccount(id, account);
		if (obj==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id+"/"+account,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id+"/"+account, exceptionResponse);
		}
		return obj;
	}




	private void validate(Client client) {
		// Details omitted
	}

}
