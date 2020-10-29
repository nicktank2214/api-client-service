package com.armadillo.api.clientservice.service;




import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.armadillo.api.clientservice.Constants;
import com.armadillo.api.clientservice.domain.Account;
import com.armadillo.api.clientservice.dto.AccountDto;
import com.armadillo.api.clientservice.repository.AccountRepository;

import com.armadillo.api.exception.ApplicationException;
import com.armadillo.api.exception.ExceptionResponse;



/**
 * Account Service
 * ------------
 * 
 * Build your @Service’s around business capabilities - 
 * Services are another core concept in Spring Boot. 
 * I find it best to build services around business capabilities/domains/use-cases, call it what you want.
 * You could decide to go with a 1-to-1 mapping between Controllers and Services. 
 * 
 */
@Service
public class AccountService {


	//private final Logger log = LoggerFactory.getLogger(this.getClass());


	//inject repositories
	private AccountRepository accountRepository;



	//constructor
	@Autowired 
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;	
	}




	/**
	 * Create a account
	 */
	public AccountDto createAccount(AccountDto dto)  throws ApplicationException {

		Account accountExists= null;
		try{accountExists= accountRepository.findById(dto.getAccount()).get();}catch(Exception e) {}
		if (accountExists!=null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_003, 
					Constants.ERROR_MESSAGE_TEXT_003+dto.getAccount(),  
					Constants.ERROR_MESSAGE_TYPE_003
					);			
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_003 +dto.getAccount(), exceptionResponse);			
		}

		Account newAccount = new Account( 
				dto.getAccount(),
				dto.getPartner(),
				dto.getSalesId(),
				dto.getCardType(),
				dto.getCardNumber(),
				dto.getCardValidfrom(),
				dto.getCardExpiry(),
				dto.getSwitchNumber(),
				dto.getCardholderName(),
				dto.getSaveCard(),
				dto.getBillingCompany(),
				dto.getBillingTelephone(),
				dto.getBillingFax(),
				dto.getBillingAddr1(),
				dto.getBillingAddr2(),
				dto.getBillingTown(),
				dto.getBillingCounty(),
				dto.getBillingCountry(),
				dto.getBillingPostcode(),
				dto.getBillingContact(),
				dto.getBillingEmail(),
				dto.getBillingEmailCc(),
				dto.getInvoicePeriod(),
				dto.getPaymentType(),
				dto.getVatNumber(),
				dto.getVatExempt(),
				dto.getPriceBand(),
				dto.getGoodCustomer(),
				dto.getInternationalDiscountpercent(),
				dto.getCompanieshouseDiscountpercent(),
				dto.getInvoiceMethod(),
				dto.getAccountType()
				);

		validate(newAccount);

		Account account = accountRepository.save(newAccount);
		return toDto(account);
	}


	/**
	 * Update account
	 */    
	public AccountDto updateAccount(String id, AccountDto dto)  throws ApplicationException {
		Account account = null;
		account = this.verifyAccount(id);

		if (dto.getPartner()!=null) {		
			account.setPartner(dto.getPartner());
		}
		if (dto.getSalesId()!=null) {		
			account.setSalesId(dto.getSalesId());
		}		
		if (dto.getCardType()!=null) {		
			account.setCardType(dto.getCardType());
		}	
		if (dto.getCardNumber()!=null) {		
			account.setCardNumber(dto.getCardNumber());
		}	
		if (dto.getCardValidfrom()!=null) {		
			account.setCardValidfrom(dto.getCardValidfrom());
		}	
		if (dto.getCardExpiry()!=null) {		
			account.setCardExpiry(dto.getCardExpiry());
		}			
		if (dto.getSwitchNumber()!=null) {		
			account.setSwitchNumber(dto.getSwitchNumber());
		}	
		if (dto.getCardholderName()!=null) {		
			account.setCardholderName(dto.getCardholderName());
		}	
		if (dto.getSaveCard()!=null) {		
			account.setSaveCard(dto.getSaveCard());
		}	
		if (dto.getBillingCompany()!=null) {		
			account.setBillingCompany(dto.getBillingCompany());
		}
		if (dto.getBillingTelephone()!=null) {		
			account.setBillingTelephone(dto.getBillingTelephone());
		}
		if (dto.getBillingFax()!=null) {		
			account.setBillingFax(dto.getBillingFax());
		}
		if (dto.getBillingAddr1()!=null) {		
			account.setBillingAddr1(dto.getBillingAddr1());
		}
		if (dto.getBillingAddr2()!=null) {		
			account.setBillingAddr2(dto.getBillingAddr2());
		}		
		if (dto.getBillingTown()!=null) {		
			account.setBillingTown(dto.getBillingTown());
		}	
		if (dto.getBillingCounty()!=null) {		
			account.setBillingCounty(dto.getBillingCounty());
		}	
		if (dto.getBillingCountry()!=null) {		
			account.setBillingCountry(dto.getBillingCountry());
		}	
		if (dto.getBillingPostcode()!=null) {		
			account.setBillingPostcode(dto.getBillingPostcode());
		}	
		if (dto.getBillingContact()!=null) {		
			account.setBillingContact(dto.getBillingContact());
		}
		if (dto.getBillingEmail()!=null) {		
			account.setBillingEmail(dto.getBillingEmail());
		}
		if (dto.getBillingEmailCc()!=null) {		
			account.setBillingEmailCc(dto.getBillingEmailCc());
		}
		if (dto.getInvoicePeriod()!=null) {		
			account.setInvoicePeriod(dto.getInvoicePeriod());
		}	
		if (dto.getPaymentType()!=null) {		
			account.setPaymentType(dto.getPaymentType());
		}	
		if (dto.getVatNumber()!=null) {		
			account.setVatNumber(dto.getVatNumber());
		}	
		if (dto.getVatExempt()!=null) {		
			account.setVatExempt(dto.getVatExempt());
		}	
		if (dto.getPriceBand()!=null) {		
			account.setPriceBand(dto.getPriceBand());
		}	
		if (dto.getGoodCustomer()!=null) {		
			account.setGoodCustomer(dto.getGoodCustomer());
		}	
		if (dto.getInternationalDiscountpercent()!=null) {		
			account.setInternationalDiscountpercent(dto.getInternationalDiscountpercent());
		}	
		if (dto.getCompanieshouseDiscountpercent()!=null) {		
			account.setCompanieshouseDiscountpercent(dto.getCompanieshouseDiscountpercent());
		}	
		if (dto.getInvoiceMethod()!=null) {		
			account.setInvoiceMethod(dto.getInvoiceMethod());
		}					
		if (dto.getAccountType()!=null) {		
			account.setAccountType(dto.getAccountType());
		}	
		
		validate(account);

		return toDto(accountRepository.save(account));
	}


	/**
	 *
	 */ 
	public AccountDto getAccountById(String id)  throws ApplicationException {
		Account account = null;
		account = this.verifyAccount(id);

		return toDto(account);
	}    

	
	public List<AccountDto> findAccountsByAccount(String account) throws ApplicationException {
		Iterable<Account> listIterable = accountRepository.findByAccount(account);
		List<AccountDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_account -> toDto(_account))
				.collect(Collectors.toList());    
		return dtoList;
	}

	
	public List<AccountDto> findAccountsByCompany(String company) throws ApplicationException {
		Iterable<Account> listIterable = accountRepository.findByBillingCompanyStartingWith(company);
		List<AccountDto> dtoList = 
				StreamSupport.stream(listIterable.spliterator(), false)
				.map(_account -> toDto(_account))
				.collect(Collectors.toList());    
		return dtoList;
	}
	

	/**
	 * 
	 */   
	public List<AccountDto> getAllAccounts()  throws ApplicationException {
		Iterable<Account> listIterable = accountRepository.findAll();
		StreamSupport.stream(listIterable.spliterator(), false);
		List<AccountDto> dtoList = StreamSupport.stream(listIterable.spliterator(), false).map(
				_account -> toDto(_account)).collect(Collectors.toList()
						);    
		return dtoList;
	}   


	/**
	 * Convert the account entity to a AccountDto
	 */
	private AccountDto toDto(Account account) {  
		AccountDto dto = new AccountDto(
				account.getAccount(),
				account.getPartner(),
				account.getSalesId(),
				account.getCardType(),
				account.getCardNumber(),
				account.getCardValidfrom(),
				account.getCardExpiry(),
				account.getSwitchNumber(),
				account.getCardholderName(),
				account.getSaveCard(),
				account.getBillingCompany(),
				account.getBillingTelephone(),
				account.getBillingFax(),
				account.getBillingAddr1(),
				account.getBillingAddr2(),
				account.getBillingTown(),
				account.getBillingCounty(),
				account.getBillingCountry(),
				account.getBillingPostcode(),
				account.getBillingContact(),
				account.getBillingEmail(),
				account.getBillingEmailCc(),
				account.getInvoicePeriod(),
				account.getPaymentType(),
				account.getVatNumber(),
				account.getVatExempt(),
				account.getPriceBand(),
				account.getGoodCustomer(),
				account.getInternationalDiscountpercent(),
				account.getCompanieshouseDiscountpercent(),
				account.getInvoiceMethod(),
				account.getAccountType(),
				""//action
				);

		return dto;
	}




	/**
	 * Verify and return the Account given an id.
	 */
	private Account verifyAccount(String id) throws ApplicationException {
		Account account= accountRepository.findById(id).get();
		if (account==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(
					Constants.ERROR_MESSAGE_CODE_001, 
					Constants.ERROR_MESSAGE_TEXT_001+id,  
					Constants.ERROR_MESSAGE_TYPE_001
					);
			throw new ApplicationException(Constants.ERROR_MESSAGE_TEXT_001 + id, exceptionResponse);
		}
		return account;
	}






	private void validate(Account account) {
		// Details omitted
	}

}
