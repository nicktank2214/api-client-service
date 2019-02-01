package com.armadillo.api.clientservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.clientservice.domain.User;

/**
 * User Repository Interface
 */
//change API ENDPOINT from default /users to /user
@RepositoryRestResource(exported = false)
public interface UserRepository 
extends CrudRepository<User,Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/user/1

	//standard find ALL
	//<GET>http://localhost:8080/user


	
	//standard find by name
	User findByUserName(String userName);
	
	List<User> findByUserNameLike(String searchTerm);

	List<User> getByUserNameContaining(String searchTerm);
    
	List<User> readByUserNameStartingWith(String searchTerm);
    
    	
}
