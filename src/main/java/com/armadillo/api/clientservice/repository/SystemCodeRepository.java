package com.armadillo.api.clientservice.repository;



import java.util.List;


import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.armadillo.api.clientservice.domain.SystemCode;




/**
 * System Code Repository Interface
 */
//change API ENDPOINT from default /systemcodes to /systemcode
@RepositoryRestResource(exported = false)
public interface SystemCodeRepository 
extends CrudRepository<SystemCode,Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/systemcode/1

	//standard find ALL
	//<GET>http://localhost:8080/systemcode

	
	//standard find by codetype 
	SystemCode findByCodeTypeAndCodeValue(String codeType, String codeValue);
	
	List<SystemCode> findByCodeType(String codetype);

    
    
	
	
	//OVERRIDE THE STANDARD CRUD METHODS FOR DELETE ALL SO THAT THE API CANNOT ACCESS THESE ENDPOINTS------------->
	@Override
	@RestResource(exported=false) 
	void deleteAll();

	@Override
	@RestResource(exported=false) 
	void deleteAll(Iterable<? extends SystemCode> arg0);

	@Override
	@RestResource(exported=false) 
	void deleteById(Integer arg0);
	//OVERRIDE THE STANDARD CRUD METHODS FOR SAVE/DELETE SO THAT THE API CANNOT ACCESS THESE ENDPOINTS-------------<

	
}
