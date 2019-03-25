package com.armadillo.api.clientservice.repository;



import java.util.List;


import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.armadillo.api.clientservice.domain.AccountCode;




/**
 * Account Code Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface AccountCodeRepository 
extends CrudRepository<AccountCode,Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/accountcode/1

	//standard find ALL
	//<GET>http://localhost:8080/accountcode

	
	//standard find by accountcode / codetype / codevalue 
	AccountCode findByAccountAndCodeTypeAndCodeValue(String account, String codeType, String codeValue);

	//standard find by accountcode / codetype 
	AccountCode findByAccountAndCodeType(String account, String codeType);
	
	List<AccountCode> findByAccount(String account);

    
    
	
	
	//OVERRIDE THE STANDARD CRUD METHODS FOR DELETE ALL SO THAT THE API CANNOT ACCESS THESE ENDPOINTS------------->
	@Override
	@RestResource(exported=false) 
	void deleteAll();

	@Override
	@RestResource(exported=false) 
	void deleteAll(Iterable<? extends AccountCode> arg0);

	@Override
	@RestResource(exported=false) 
	void deleteById(Integer arg0);
	//OVERRIDE THE STANDARD CRUD METHODS FOR SAVE/DELETE SO THAT THE API CANNOT ACCESS THESE ENDPOINTS-------------<

	
}
