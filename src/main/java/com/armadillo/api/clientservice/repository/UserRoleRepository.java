package com.armadillo.api.clientservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.armadillo.api.clientservice.domain.UserRole;

/**
 * UserRole Repository Interface
 */
//change API ENDPOINT from default /useroles to /userrole
@RepositoryRestResource(exported = false)
public interface UserRoleRepository 
extends CrudRepository<UserRole,Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/userrole/1

	//standard find ALL
	//<GET>http://localhost:8080/userrole

	
	//find list by userid
	List<UserRole> findByUserId(Integer id);

	
	

}
