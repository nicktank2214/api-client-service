package com.armadillo.api.clientservice.repository;



import java.util.List;


import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.armadillo.api.clientservice.domain.Country;








/**
 * Country Repository Interface
 */
//change API ENDPOINT from default /countrys to /country
@RepositoryRestResource(exported = false)
public interface CountryRepository 
extends CrudRepository<Country,Integer> {
	
	
	//standard find by id
	//<GET>http://localhost:8080/country/1
	
	//standard find ALL
	//<GET>http://localhost:8080/country

	//standard find by name
	Country findByCountryCode(String countryCode);
	
	//standard find by name
	List<Country> findByCountryName(String searchTerm);	
	
	List<Country> findByCountryNameLike(String searchTerm);

	List<Country> getByCountryNameContaining(String searchTerm);
    
	List<Country> readByCountryNameStartingWith(String searchTerm);
    
    
	
}
