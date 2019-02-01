package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;

import com.armadillo.api.clientservice.domain.SystemCode;
import com.armadillo.api.clientservice.dto.SystemCodeDto;
import com.armadillo.api.clientservice.repository.SystemCodeRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * SystemCode Service
 * ------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class SystemCodeService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private SystemCodeRepository systemCodeRepository;



	//constructor
	@Autowired 
	public SystemCodeService(SystemCodeRepository systemCodeRepository) {
		this.systemCodeRepository = systemCodeRepository;	
	}






	/**
	 *
	 */ 
	public SystemCodeDto getSystemCodeById(Integer id)  throws ApplicationException {
		SystemCode systemCode = null;
		systemCode = this.verifySystemCode(id);

		return toDto(systemCode);
	}    

	
	/**
	 * 
	 */
	public SystemCodeDto findByCodeTypeAndCodeValue(
			String type,
			String value
			)  throws ApplicationException {
		
		SystemCode systemCode = null;
		systemCode = this.verifySystemCodeByCodeTypeAndCodeValue(type, value);		

		return toDto(systemCode);	
	}
	
	

	/**
	 * 
	 */   
	public List<SystemCodeDto> getAllSystemCodes()  throws ApplicationException {
		Iterable<SystemCode> listIterable = systemCodeRepository.findAll();
		List<SystemCodeDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((SystemCode c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   

	
	/**
	 * 
	 */   
	public List<SystemCodeDto> findByCodeType(
			String type
			)  throws ApplicationException {
		Iterable<SystemCode> listIterable = systemCodeRepository.findByCodeType(type);
		List<SystemCodeDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((SystemCode c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   
	

	/**
	 * Convert the systemCode entity to a SystemCodeDto
	 */
	private SystemCodeDto toDto(SystemCode systemCode) {  
		SystemCodeDto dto = new SystemCodeDto(
				systemCode.getSystemCodeId(),
				systemCode.getCodeType(),
				systemCode.getCodeValue(),
				systemCode.getDescription()
				);

		return dto;
	}



	/**
	 * Verify and return the SystemCode given an id.
	 */
	private SystemCode verifySystemCode(Integer id) throws ApplicationException {
		SystemCode systemCode= systemCodeRepository.findById(id).get();
		if (systemCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return systemCode;
	}


	/**
	 * Verify and return the SystemCode given an id.
	 */
	private SystemCode verifySystemCodeByCodeTypeAndCodeValue(
			String codeType, 
    		String codeValue			
			) throws ApplicationException {
		SystemCode systemCode= systemCodeRepository.findByCodeTypeAndCodeValue(codeType, codeValue);
		if (systemCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+codeType+" / "+codeValue,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + codeType+" / "+codeValue, exceptionResponse);
		}
		return systemCode;
	}
	
	

	
}
