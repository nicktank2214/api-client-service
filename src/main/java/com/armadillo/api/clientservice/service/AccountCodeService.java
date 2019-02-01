package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;

import com.armadillo.api.clientservice.domain.AccountCode;
import com.armadillo.api.clientservice.dto.AccountCodeDto;
import com.armadillo.api.clientservice.repository.AccountCodeRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * AccountCode Service
 * ------------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class AccountCodeService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());



	//inject repositories
	private AccountCodeRepository systemCodeRepository;



	//constructor
	@Autowired 
	public AccountCodeService(AccountCodeRepository systemCodeRepository) {
		this.systemCodeRepository = systemCodeRepository;	
	}






	/**
	 *
	 */ 
	public AccountCodeDto getAccountCodeById(Integer id)  throws ApplicationException {
		AccountCode systemCode = null;
		systemCode = this.verifyAccountCode(id);

		return toDto(systemCode);
	}    

	
	/**
	 * 
	 */
	public AccountCodeDto findByAccountAndCodeTypeAndCodeValue(
			String account,
			String type,
			String value
			)  throws ApplicationException {
		
		AccountCode systemCode = null;
		systemCode = this.verifyAccountCodeByAccountAndCodeTypeAndCodeValue(account, type, value);		

		return toDto(systemCode);	
	}
	
	

	/**
	 * 
	 */   
	public List<AccountCodeDto> getAllAccountCodes()  throws ApplicationException {
		Iterable<AccountCode> listIterable = systemCodeRepository.findAll();
		List<AccountCodeDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((AccountCode c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   

	
	/**
	 * 
	 */   
	public List<AccountCodeDto> findByAccount(
			String account
			)  throws ApplicationException {
		Iterable<AccountCode> listIterable = systemCodeRepository.findByAccount(account);
		List<AccountCodeDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((AccountCode c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   
	

	/**
	 * Convert the systemCode entity to a AccountCodeDto
	 */
	private AccountCodeDto toDto(AccountCode accountCode) {  
		AccountCodeDto dto = new AccountCodeDto(
				accountCode.getAccountCodeId(),
				accountCode.getCodeType(),
				accountCode.getCodeValue(),
				accountCode.getDescription(),
				accountCode.getAccount()
				);

		return dto;
	}



	/**
	 * Verify and return the AccountCode given an id.
	 */
	private AccountCode verifyAccountCode(Integer id) throws ApplicationException {
		AccountCode systemCode= systemCodeRepository.findById(id).get();
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
	 * Verify and return the AccountCode given an id.
	 */
	private AccountCode verifyAccountCodeByAccountAndCodeTypeAndCodeValue(
			String accountCode, 			
			String codeType, 
    		String codeValue			
			) throws ApplicationException {
		AccountCode systemCode= systemCodeRepository.findByAccountAndCodeTypeAndCodeValue(accountCode, codeType, codeValue);
		if (systemCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+accountCode+" / "+codeType+" / "+codeValue,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + accountCode+" / "+codeType+" / "+codeValue, exceptionResponse);
		}
		return systemCode;
	}
	
	

	
}
