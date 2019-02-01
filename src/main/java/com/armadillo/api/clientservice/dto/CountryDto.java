package com.armadillo.api.clientservice.dto;


import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;




/**
 * Data Transfer Object for country
 */
public class CountryDto {


    @JsonProperty("country_id")
    private Integer countryId;


    @Size(max = 200)
    @JsonProperty("country_name")    
    private String countryName;


    @Size(max = 20)
    @JsonProperty("country_code")    
    private String countryCode;



    @JsonProperty("supplier")  	
    private String supplier;

    @JsonProperty("online")  	
    private String online;
    
    @JsonProperty("notes")  	
    private String notes;
    
    @JsonProperty("delivery")  	
    private String delivery;

    @JsonProperty("language")  	
    private String language;
    

	
	
	
	
	public CountryDto(
			Integer countryId, 
			String countryName, 
			String countryCode,
			String supplier,
			String online,
			String notes,
			String delivery,
			String language				
			) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.supplier=supplier;
		this.online=online;
		this.notes=notes;
		this.delivery=delivery;
		this.language=language;			
	}
	public CountryDto(
			String countryName, 
			String countryCode,
			String supplier,
			String online,
			String notes,
			String delivery,
			String language					
			) {
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.supplier=supplier;
		this.online=online;
		this.notes=notes;
		this.delivery=delivery;
		this.language=language;			
	}
	protected CountryDto() {
	}	

	
	
	
	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	
	
	

	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	@Override
	public String toString() {
		return "CountryDto [countryId=" + countryId + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", supplier=" + supplier + ", online=" + online + ", notes=" + notes + ", delivery=" + delivery
				+ ", language=" + language + "]";
	}
	
	
	

}
