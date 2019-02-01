package com.armadillo.api.clientservice.dto;



import com.fasterxml.jackson.annotation.JsonProperty;



/**
 */
public class AccountCodeDto {


    
    @JsonProperty ("account_code_id")	
    private Integer accountCodeId;

    @JsonProperty ("account")
    private String account;

    @JsonProperty ("code_type")
    private String codeType;

    @JsonProperty ("code_value")
    private String codeValue;
	
    @JsonProperty ("description")
    private String description;
    



	public AccountCodeDto(
			Integer accountCodeId, 
			String codeType, 
			String codeValue, 
			String description,
			String account
			) {
		this.accountCodeId = accountCodeId;
		this.codeType = codeType;
		this.codeValue = codeValue;
		this.description = description;
		this.account = account;			
	}
	public AccountCodeDto(
			String codeType, 
			String codeValue, 
			String description,
			String account
			) {
		this.codeType = codeType;
		this.codeValue = codeValue;
		this.description = description;
		this.account = account;			
	}
	public AccountCodeDto() {
	}
	
	
	
	public Integer getAccountCodeId() {
		return accountCodeId;
	}
	public void setAccountCodeId(Integer accountCodeId) {
		this.accountCodeId = accountCodeId;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	@Override
	public String toString() {
		return "AccountCodeDto [accountCodeId=" + accountCodeId + ", account=" + account + ", codeType="
				+ codeType + ", codeValue=" + codeValue + ", description=" + description + "]";
	}
	


	
}
