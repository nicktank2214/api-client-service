package com.armadillo.api.clientservice.repository;



import java.util.List;

import org.springframework.data.domain.Sort;
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
	List<Country> findAll(Sort sort);	

	//standard find by name
	Country findByCountryCode(String countryCode);
	

	List<Country> findByLanguageOrderByCountryNameAsc(String searchTerm);	
	
	List<Country> findByCountryNameOrderByCountryNameAsc(String searchTerm);	
	
	List<Country> findByCountryNameLikeOrderByCountryNameAsc(String searchTerm);

	List<Country> getByCountryNameContainingOrderByCountryNameAsc(String searchTerm);
    
	List<Country> readByCountryNameStartingWithOrderByCountryNameAsc(String searchTerm);
    
    
	
}
