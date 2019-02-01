package com.armadillo.api.clientservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.clientservice.domain.Account;


/**
 * Account Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface AccountRepository extends CrudRepository<Account,String> {
	
	
	// find by id
	//<GET>http://localhost:8080/account/1

	// find ALL
	//<GET>http://localhost:8080/account
    
	//standard find by account
	List<Account> findByAccount(String account);
	
	List<Account> findByBillingCompanyStartingWith(String searchValue);
	
}
