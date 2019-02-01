package com.armadillo.api.clientservice.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.clientservice.domain.Client;



/**
 * Client Repository Interface
 */
@RepositoryRestResource(exported = false)
public interface ClientRepository extends CrudRepository<Client,Integer> {
	
	
	// find by id
	//<GET>http://localhost:8080/client/1

	// find ALL
	//<GET>http://localhost:8080/client
 
	//standard find by account
	List<Client> findByAccount(String account);

	//standard find by client
	List<Client> findByClient(Integer client);
	
	//find by client and account
	Client findByClientAndAccount(Integer client, String account);
	
	
}
