package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;
import com.armadillo.api.clientservice.domain.Manager;
import com.armadillo.api.clientservice.dto.ManagerDto;
import com.armadillo.api.clientservice.repository.ManagerRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Manager Service
 * ---------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class ManagerService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private ManagerRepository managerRepository;



	//constructor
	@Autowired 
	public ManagerService(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;	
	}




	/**
	 * Create a manager
	 */
	public ManagerDto createManager(ManagerDto dto)  throws ApplicationException {

		Manager managerExists= managerRepository.findById(dto.getId()).get();
		if (managerExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getId(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getId(), exceptionResponse);			
		}

		Manager newManager = new Manager( 
				dto.getId(),			
				dto.getPassword()
				);

		validate(newManager);

		Manager manager = managerRepository.save(newManager);
		return toDto(manager);
	}


	/**
	 * Update manager
	 */    
	public ManagerDto updateManager(String id, ManagerDto dto)  throws ApplicationException {
		Manager manager = null;
		manager = this.verifyManager(id);
		
		if (dto.getPassword()!=null) {		
			manager.setPassword(dto.getPassword());
		}
	
		validate(manager);

		return toDto(managerRepository.save(manager));
	}


	/**
	 *
	 */ 
	public ManagerDto getManagerById(String id)  throws ApplicationException {
		Manager manager = null;
		manager = this.verifyManager(id);

		return toDto(manager);
	}    


	/**
	 * 
	 */   
	public List<ManagerDto> getAllManagers()  throws ApplicationException {
		Iterable<Manager> listIterable = managerRepository.findAll();
		List<ManagerDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_manager -> toDto(_manager)).collect(Collectors.toList()
						);    
		return dtoList;
	}   


	/**
	 * Convert the manager entity to a ManagerDto
	 */
	private ManagerDto toDto(Manager manager) {  
		ManagerDto dto = new ManagerDto(
				manager.getId(),			
				manager.getPassword()
				);

		return dto;
	}



	/**
	 * Verify and return the Manager given an id.
	 */
	private Manager verifyManager(String id) throws ApplicationException {
		Manager manager= managerRepository.findById(id).get();
		if (manager==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return manager;
	}






	private void validate(Manager manager) {
		// Details omitted
	}

}
