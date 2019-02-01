package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;

import com.armadillo.api.clientservice.domain.Country;
import com.armadillo.api.clientservice.dto.CountryDto;
import com.armadillo.api.clientservice.repository.CountryRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Country Service
 * ---------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class CountryService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private CountryRepository countryRepository;



	//constructor
	@Autowired 
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;	
	}






	/**
	 *
	 */ 
	public CountryDto getCountryById(Integer id)  throws ApplicationException {
		Country country = null;
		country = this.verifyCountry(id);

		return toDto(country);
	}    

	
	/**
	 * 
	 */
	public CountryDto getCountryByCountryCode(
			String countrycode
			)  throws ApplicationException {
		Country country = null;
		country = this.verifyCountryByCountryCode(countrycode);		

		return toDto(country);	
	}
	
	

	/**
	 * 
	 */   
	public List<CountryDto> getAllCountrys()  throws ApplicationException {
		Iterable<Country> listIterable = countryRepository.findAll();
		List<CountryDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((Country c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   


	/**
	 * Convert the country entity to a CountryDto
	 */
	private CountryDto toDto(Country country) {  
		CountryDto dto = new CountryDto(
				country.getCountryId(),			
				country.getCountryName(),
				country.getCountryCode(),
				country.getSupplier(),
				country.getOnline(),
				country.getNotes(),
				country.getDelivery(),
				country.getLanguage()						
				);

		return dto;
	}



	/**
	 * Verify and return the Country given an id.
	 */
	private Country verifyCountry(Integer id) throws ApplicationException {
		Country country= countryRepository.findById(id).get();
		if (country==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return country;
	}


	/**
	 * Verify and return the Country given an id.
	 */
	private Country verifyCountryByCountryCode(String id) throws ApplicationException {
		Country country= countryRepository.findByCountryCode(id);
		if (country==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return country;
	}
	
	

}
