package com.armadillo.api.clientservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.clientservice.domain.Manager;


/**
 * Manager Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ManagerRepository extends CrudRepository<Manager,String> {
	
	
	// find by id
	//<GET>http://localhost:8080/manager/RM

	// find ALL
	//<GET>http://localhost:8080/manager/list
    
    	
}
