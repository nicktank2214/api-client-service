package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	private AccountCodeRepository accountCodeRepository;



	//constructor
	@Autowired 
	public AccountCodeService(AccountCodeRepository accountCodeRepository) {
		this.accountCodeRepository = accountCodeRepository;	
	}






	/**
	 *
	 */ 
	public AccountCodeDto getAccountCodeById(Integer id)  throws ApplicationException {
		AccountCode accountCode = null;
		accountCode = this.verifyAccountCode(id);

		return toDto(accountCode);
	}    


	/**
	 * 
	 */
	public AccountCodeDto findByAccountAndCodeTypeAndCodeValue(
			String account,
			String type,
			String value
			)  throws ApplicationException {

		AccountCode accountCode = null;
		accountCode = this.verifyAccountCodeByAccountAndCodeTypeAndCodeValue(account, type, value);		

		return toDto(accountCode);	
	}


	/**
	 * 
	 */
	public AccountCodeDto findByAccountAndCodeType(
			String account,
			String type
			)  throws ApplicationException {

		AccountCode accountCode = null;
		accountCode = this.verifyAccountCodeByAccountAndCodeType(account, type);		

		return toDto(accountCode);	
	}
	
	
	/**
	 * 
	 */   
	public List<AccountCodeDto> getAllAccountCodes()  throws ApplicationException {
		Iterable<AccountCode> listIterable = accountCodeRepository.findAll();
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
		Iterable<AccountCode> listIterable = accountCodeRepository.findByAccount(account);
		List<AccountCodeDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map((AccountCode c) -> toDto(c))
				.collect(Collectors.toList());    
		return dtoList;
	}   


	/**
	 * Create 
	 */
	public AccountCodeDto createAccountCode(AccountCodeDto dto)  throws ApplicationException {

		AccountCode accountCodeExists = null;
		try {
			accountCodeExists = this.verifyAccountCodeByAccountAndCodeTypeAndCodeValue(
					dto.getAccount(),
					dto.getCodeType(),
					dto.getCodeValue()
					);
		}catch(Exception e) {}
		if (accountCodeExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_004, 
					Constants.ERROR_MESSAGE_TEXT_004+dto.getAccount()+"/"+dto.getCodeType()+"/"+dto.getCodeValue(),  
					Constants.ERROR_MESSAGE_TYPE_004
					);			
			throw new ApplicationException(
					Constants.ERROR_MESSAGE_TEXT_004+dto.getAccount()+"/"+dto.getCodeType()+"/"+dto.getCodeValue(), 
					exceptionResponse
					);			
		}

		AccountCode newAccontCode = new AccountCode( 
				dto.getCodeType(),  
				dto.getCodeValue(),  
				dto.getDescription(),
				dto.getAccount()				
				);

		validate(newAccontCode);

		AccountCode accountCode = accountCodeRepository.save(newAccontCode);
		return toDto(accountCode);
	}


	/**
	 * Update 
	 */    
	public AccountCodeDto updateAccountCode(int id, AccountCodeDto dto)  throws ApplicationException {		
		AccountCode accountCode=null; 
		accountCode= this.verifyAccountCode(dto.getAccountCodeId());		

		if (dto.getAccount()!=null) {
			accountCode.setAccount(dto.getAccount());  
		}
		if (dto.getCodeType()!=null) {
			accountCode.setCodeType(dto.getCodeType());  
		}
		if (dto.getCodeValue()!=null) {
			accountCode.setCodeValue(dto.getCodeValue());  
		}		
		if (dto.getDescription()!=null) {
			accountCode.setDescription(dto.getDescription());  
		}	

		validate(accountCode);

		return toDto(accountCodeRepository.save(accountCode));
	}


	/**
	 * Delete 
	 */
	public void hardDeleteById(@PathVariable(value = "id") int id)  throws ApplicationException {
		AccountCode accountCode = null;
		accountCode = this.verifyAccountCode(id);       
		if (accountCode != null) {
			accountCodeRepository.delete(accountCode);
		} 
	} 



	/**
	 * Convert the accountCode entity to a AccountCodeDto
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


	private void validate(AccountCode accountCode) {
		// Details omitted
	}



	/**
	 * Verify and return the AccountCode given an id.
	 */
	private AccountCode verifyAccountCode(Integer id) throws ApplicationException {
		AccountCode accountCode= accountCodeRepository.findById(id).get();
		if (accountCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return accountCode;
	}


	/**
	 * Verify and return the AccountCode given an id.
	 */
	private AccountCode verifyAccountCodeByAccountAndCodeTypeAndCodeValue(
			String account, 			
			String codeType, 
			String codeValue			
			) throws ApplicationException {
		AccountCode accountCode= accountCodeRepository.findByAccountAndCodeTypeAndCodeValue(account, codeType, codeValue);
		if (accountCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+account+" / "+codeType+" / "+codeValue,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + accountCode+" / "+codeType+" / "+codeValue, exceptionResponse);
		}
		return accountCode;
	}

	
	/**
	 * Verify and return the AccountCode given an id.
	 */
	private AccountCode verifyAccountCodeByAccountAndCodeType(
			String account, 			
			String codeType			
			) throws ApplicationException {
		AccountCode accountCode= accountCodeRepository.findByAccountAndCodeType(account, codeType);
		if (accountCode==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+account+" / "+codeType,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + accountCode+" / "+codeType, exceptionResponse);
		}
		return accountCode;
	}



}
