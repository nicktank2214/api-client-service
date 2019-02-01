package com.armadillo.api.clientservice.service;




import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.armadillo.api.clientservice.Constants;
import com.armadillo.api.clientservice.domain.User;
import com.armadillo.api.clientservice.domain.UserRole;

import com.armadillo.api.clientservice.dto.UserRoleDto;

import com.armadillo.api.clientservice.repository.UserRepository;
import com.armadillo.api.clientservice.repository.UserRoleRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * User Role Service
 * -----------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class UserRoleService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());


	UserRoleRepository userRoleRepository;
	UserRepository userRepository;
	
	
	@Autowired
	public UserRoleService(UserRoleRepository userRoleRepository, UserRepository userRepository) {
		this.userRoleRepository = userRoleRepository;
		this.userRepository = userRepository;		
	}




	/**
	 * Create a user
	 */
	public UserRoleDto createUserRole(UserRoleDto dto)  throws ApplicationException {

		this.verifyUser(dto.getUserId());
		
		UserRole newUserRole = userRoleRepository.save(
				new UserRole( 
						dto.getUserId(),
						dto.getRole()
						)
				);

		validate(newUserRole);

		UserRole userRole = userRoleRepository.save(newUserRole);
		return toDto(userRole);
	}


	public List<UserRoleDto> findUserRolesByUserId(@PathVariable(value = "id") int id) {

		Iterable<UserRole> listIterable = userRoleRepository.findByUserId(id);
		List<UserRoleDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_userrole -> toDto(_userrole)).collect(Collectors.toList()
						);    

		return dtoList;
	}

	
	/**
	 *
	 */ 
	public UserRoleDto getUserRoleById(int id)  throws ApplicationException {
		UserRole userRole = null;
		userRole = this.verifyUserRole(id);

		return toDto(userRole);
	}    


	/**
	 * 
	 */   
	public List<UserRoleDto> getAllUsers()  throws ApplicationException {
		Iterable<UserRole> listIterable = userRoleRepository.findAll();
		List<UserRoleDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_userrole -> toDto(_userrole)).collect(Collectors.toList()
						);    
		return dtoList;
	}   


	/**
	 * Convert the user entity to a UserRoleDto
	 */
	private UserRoleDto toDto(UserRole userRole) {   	
		return new UserRoleDto(
				userRole.getUserRoleId(), 
				userRole.getUserId(), 
				userRole.getRole()
				);
	}
	

	/**
	 * Verify and return the User given an id.
	 */
	private UserRole verifyUserRole(int id) throws ApplicationException {
		UserRole userRole= userRoleRepository.findById(id).get();
		if (userRole==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return userRole;
	}


	/**
	 * Verify and return the User given an id.
	 */
	private User verifyUser(int id) throws ApplicationException {
		User user= userRepository.findById(id).get();
		if (user==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return user;
	}
	


	private void validate(UserRole userRole) {
		// Details omitted
	}

}
