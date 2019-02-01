package com.armadillo.api.clientservice.domain;

import javax.persistence.*;


import java.io.Serializable;


/**
 */
@Entity
@Table (name="country")
public class Country implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
    @Column (name="countryid")	
    private Integer countryId;

	@Column (name="countryname")
    private String countryName;

	@Column (name="countrycode")
    private String countryCode;

	@Column (name="supplier")
    private String supplier;
	
	@Column (name="online")
    private String online;
	
	@Column (name="notes")
    private String notes;
	
	@Column (name="delivery")
    private String delivery;
	
	@Column (name="language")
    private String language;
	
	
	
	
	public Country(
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
	public Country(
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
	public Country() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((online == null) ? 0 : online.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (online == null) {
			if (other.online != null)
				return false;
		} else if (!online.equals(other.online))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", supplier=" + supplier + ", online=" + online + ", notes=" + notes + ", delivery=" + delivery
				+ ", language=" + language + "]";
	}



}
