package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;
import com.armadillo.api.clientservice.domain.User;
import com.armadillo.api.clientservice.domain.UserRole;
import com.armadillo.api.clientservice.dto.UserDto;
import com.armadillo.api.clientservice.dto.UserRoleDto;
import com.armadillo.api.clientservice.repository.UserRepository;
import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * User Service
 * ------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class UserService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private PasswordEncoder passwordEncoder;


	//inject repositories
	private UserRepository userRepository;



	//constructor
	@Autowired 
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;	
	}




	/**
	 * Create a user
	 */
	public UserDto createUser(UserDto dto)  throws ApplicationException {

		User userExists = this.verifyUserByUserName(dto.getUserName());
		if (userExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_002, 
					Constants.ERROR_MESSAGE_TEXT_002+dto.getUserName(),  
					Constants.ERROR_MESSAGE_TYPE_002
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_002 +dto.getUserName(), exceptionResponse);			
		}

		User newUser = new User( 
				passwordEncoder.encode(dto.getPassword()),
				dto.getUserName(), 
				dto.getFirstName(), 
				dto.getLastName(), 
				dto.getRoleId(),
				dto.getDepartmentId(), 
				//dto.getDisabledFlag(),
				0,//default new record to disabledFlag off
				//dto.getActiveFlag()
				1//default new record to activeflag on
				);

		validate(newUser);

		User user = userRepository.save(newUser);
		return toDto(user);
	}


	/**
	 * Update user
	 */    
	public UserDto updateUser(int id, UserDto dto)  throws ApplicationException {
		User user = null;
		user = this.verifyUser(id);

		if (dto.getUserName()!=null) {
			user.setUserName(dto.getUserName());  
		}
		if (dto.getPassword()!=null) {		
			user.setPassword(
					dto.getPassword()//passwordEncoder.encode(dto.getPassword())
					);
			//user.setPassword(dto.getPassword());
		}
		if (dto.getFirstName()!=null) {		
			user.setFirstName(dto.getFirstName());
		}
		if (dto.getLastName()!=null) {		
			user.setLastName(dto.getLastName());
		}		
		if (dto.getRoleId()!=null) {		
			user.setRoleId(dto.getRoleId());
		}	
		if (dto.getDepartmentId()!=null) {		
			user.setDepartmentId(dto.getDepartmentId());
		}	
		if (dto.getDisabledFlag()!=null) {		
			user.setDisabledFlag(dto.getDisabledFlag());
		}	
		if (dto.getActiveFlag()!=null) {		
			user.setActiveFlag(dto.getActiveFlag());
		}			

		validate(user);

		return toDto(userRepository.save(user));
	}


	/**
	 *
	 */ 
	public UserDto getUserById(int id)  throws ApplicationException {
		User user = null;
		user = this.verifyUser(id);

		return toDto(user);
	}    


	/**
	 * 
	 */
	public UserDto getUserByUserName(
			String name
			)  throws ApplicationException {
		User user = null;
		user = this.verifyUserByUserName(name); 

		return toDto(user);		
	}



	/**
	 * includes extra code to test LAMBDA and STREAM (commented out)
	 */   
	public List<UserDto> getAllUsers()  throws ApplicationException {
		Iterable<User> listIterable = userRepository.findAll();
		List<UserDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
/*				.filter((User u) -> {
					System.out.println("filter username: "+u.getUserName());					
					return u.getUserRoles().stream().anyMatch((UserRole ur) -> ur.getRole().equals("ADMIN"));
				})*/
				.map((User u) -> {
					//System.out.println("map username: "+u.getUserName());
					return toDto(u);	
				})
				.collect(Collectors.toList());    
		return dtoList;
	}   



	/**
	 * Convert the user entity to a UserDto
	 */
	private UserDto toDto(User user) {  
		UserDto dto = new UserDto(
				user.getUserId(), 
				user.getPassword(), 
				user.getUserName(), 
				user.getFirstName(), 
				user.getLastName(), 
				user.getRoleId(),
				user.getDepartmentId(), 
				user.getDisabledFlag(),
				user.getActiveFlag()
				);

		if (user.getUserRoles()!=null) {
			Set<UserRoleDto> dtoList = 
					user.getUserRoles().stream()
					.map((UserRole ur) -> toUserRoleDto(ur))
					.collect(Collectors.toSet());		
			dto.setUserRoles(dtoList);
		}
		return dto;
	}


	/**
	 * Convert the user entity to a UserRoleDto
	 */
	private UserRoleDto toUserRoleDto(UserRole userRole) {   	
		return new UserRoleDto(
				userRole.getUserRoleId(), 
				userRole.getUserId(), 
				userRole.getRole()
				);
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


	/**
	 * Verify and return the User given an id.
	 */
	private User verifyUserByUserName(String name) throws ApplicationException {
		User user= userRepository.findByUserName(name);
		return user;
	}




	private void validate(User user) {
		// Details omitted
	}

}
