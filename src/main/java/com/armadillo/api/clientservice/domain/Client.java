package com.armadillo.api.clientservice.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "client")
public class Client implements Serializable {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Id
	@Column(name = "client")
	private Integer client;


	@Column(name = "password")
	private String password;

	@Column(name = "account")
	private String account;

	@Column(name = "group_id")
	private Integer groupId;

	@Column(name = "email")
	private String email;

	@Column(name = "title")
	private String title;

	@Column(name = "forename")
	private String forename;

	@Column(name = "surname")
	private String surname;

	@Column(name = "addr1")
	private String addr1;

	@Column(name = "addr2")
	private String addr2;

	@Column(name = "town")
	private String town;

	@Column(name = "county")
	private String county;

	@Column(name = "country")
	private String country;

	@Column(name = "postcode")
	private String postcode;	

	@Column(name = "company")
	private String company;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "fax")
	private String fax;

	@Column(name = "cardholder_name")
	private String cardholderName;

	@Column(name = "save_card")
	private String saveCard;

	@Column(name = "contact")
	private String contact;

	@Column(name = "ch_monthfeedue")
	private Integer chMonthfeedue;

	@Column(name = "ch_paid")
	private String chPaid;

	@Column(name = "ch_user")
	private String chUser;

	@Column(name = "clienttype")
	private String clientType;
	
	


	public Client(
			String password,
			String account,
			Integer groupId,
			String email,
			String title,
			String forename,
			String surname,
			String addr1,
			String addr2,
			String town,
			String county,
			String country,
			String postcode,	
			String company,
			String telephone,
			String fax,
			String cardholderName,
			String saveCard,
			String contact,
			Integer chMonthfeedue,
			String chPaid,
			String chUser,
			String clientType
			) {
		this.password=password;
		this.account=account;
		this.groupId=groupId;
		this.email=email;
		this.title=title;
		this.forename=forename;
		this.surname=surname;
		this.addr1=addr1;
		this.addr2=addr2;
		this.town=town;
		this.county=county;
		this.country=country;
		this.postcode=postcode;	
		this.company=company;
		this.telephone=telephone;
		this.fax=fax;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.contact=contact;
		this.chMonthfeedue=chMonthfeedue;
		this.chPaid=chPaid;
		this.chUser=chUser;	
		this.clientType=clientType;			
	}
	public Client(
			Integer client,			
			String password,
			String account,
			Integer groupId,
			String email,
			String title,
			String forename,
			String surname,
			String addr1,
			String addr2,
			String town,
			String county,
			String country,
			String postcode,	
			String company,
			String telephone,
			String fax,
			String cardholderName,
			String saveCard,
			String contact,
			Integer chMonthfeedue,
			String chPaid,
			String chUser,
			String clientType			
			) {
		this.client=client;		
		this.password=password;
		this.account=account;
		this.groupId=groupId;
		this.email=email;
		this.title=title;
		this.forename=forename;
		this.surname=surname;
		this.addr1=addr1;
		this.addr2=addr2;
		this.town=town;
		this.county=county;
		this.country=country;
		this.postcode=postcode;	
		this.company=company;
		this.telephone=telephone;
		this.fax=fax;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.contact=contact;
		this.chMonthfeedue=chMonthfeedue;
		this.chPaid=chPaid;
		this.chUser=chUser;	
		this.clientType=clientType;			
	}
	
	
	
	public Client() {
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	public String getSaveCard() {
		return saveCard;
	}
	public void setSaveCard(String saveCard) {
		this.saveCard = saveCard;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getChMonthfeedue() {
		return chMonthfeedue;
	}
	public void setChMonthfeedue(Integer chMonthfeedue) {
		this.chMonthfeedue = chMonthfeedue;
	}
	public String getChPaid() {
		return chPaid;
	}
	public void setChPaid(String chPaid) {
		this.chPaid = chPaid;
	}
	public String getChUser() {
		return chUser;
	}
	public void setChUser(String chUser) {
		this.chUser = chUser;
	}
	
	
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
		result = prime * result + ((addr1 == null) ? 0 : addr1.hashCode());
		result = prime * result + ((addr2 == null) ? 0 : addr2.hashCode());
		result = prime * result + ((cardholderName == null) ? 0 : cardholderName.hashCode());
		result = prime * result + ((chMonthfeedue == null) ? 0 : chMonthfeedue.hashCode());
		result = prime * result + ((chPaid == null) ? 0 : chPaid.hashCode());
		result = prime * result + ((chUser == null) ? 0 : chUser.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((saveCard == null) ? 0 : saveCard.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
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
		Client other = (Client) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
			return false;
		if (addr1 == null) {
			if (other.addr1 != null)
				return false;
		} else if (!addr1.equals(other.addr1))
			return false;
		if (addr2 == null) {
			if (other.addr2 != null)
				return false;
		} else if (!addr2.equals(other.addr2))
			return false;
		if (cardholderName == null) {
			if (other.cardholderName != null)
				return false;
		} else if (!cardholderName.equals(other.cardholderName))
			return false;
		if (chMonthfeedue == null) {
			if (other.chMonthfeedue != null)
				return false;
		} else if (!chMonthfeedue.equals(other.chMonthfeedue))
			return false;
		if (chPaid == null) {
			if (other.chPaid != null)
				return false;
		} else if (!chPaid.equals(other.chPaid))
			return false;
		if (chUser == null) {
			if (other.chUser != null)
				return false;
		} else if (!chUser.equals(other.chUser))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (forename == null) {
			if (other.forename != null)
				return false;
		} else if (!forename.equals(other.forename))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (saveCard == null) {
			if (other.saveCard != null)
				return false;
		} else if (!saveCard.equals(other.saveCard))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Client [client=" + client + ", password=" + password + ", account=" + account + ", groupId=" + groupId
				+ ", email=" + email + ", title=" + title + ", forename=" + forename + ", surname=" + surname
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", town=" + town + ", county=" + county + ", country="
				+ country + ", postcode=" + postcode + ", company=" + company + ", telephone=" + telephone + ", fax="
				+ fax + ", cardholderName=" + cardholderName + ", saveCard=" + saveCard + ", contact=" + contact
				+ ", chMonthfeedue=" + chMonthfeedue + ", chPaid=" + chPaid + ", chUser=" + chUser + ", clientType="
				+ clientType + "]";
	}
	




}