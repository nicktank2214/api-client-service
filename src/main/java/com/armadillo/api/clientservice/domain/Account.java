package com.armadillo.api.clientservice.domain;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "account")
public class Account implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "account")
	private String account;


	@Column(name = "partner")
	private String partner;

	@Column(name = "sales_id")
	private String salesId;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_validfrom")
	private String cardValidfrom;

	@Column(name = "card_expiry")
	private String cardExpiry;

	@Column(name = "switch_number")
	private String switchNumber;

	@Column(name = "cardholder_name")
	private String cardholderName;

	@Column(name = "save_card")
	private String saveCard;

	@Column(name = "billing_company")
	private String billingCompany;

	@Column(name = "billing_telephone")
	private String billingTelephone;

	@Column(name = "billing_fax")
	private String billingFax;

	@Column(name = "billing_addr1")
	private String billingAddr1;

	@Column(name = "billing_addr2")
	private String billingAddr2;

	@Column(name = "billing_town")
	private String billingTown;

	@Column(name = "billing_county")
	private String billingCounty;

	@Column(name = "billing_country")
	private String billingCountry;

	@Column(name = "billing_postcode")
	private String billingPostcode;

	@Column(name = "billing_contact")
	private String billingContact;

	@Column(name = "billing_email")
	private String billingEmail;

	@Column(name = "billing_email_cc")
	private String billingEmailCc;

	@Column(name = "invoice_period")
	private String invoicePeriod;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "vat_number")
	private String vatNumber;

	@Column(name = "vat_exempt")
	private String vatExempt;

	@Column(name = "priceband")
	private Integer priceBand;

	@Column(name = "goodcustomer")
	private String goodCustomer;

	@Column(name = "international_discountpercent")
	private BigDecimal internationalDiscountpercent;

	@Column(name = "companieshouse_discountpercent")
	private BigDecimal companieshouseDiscountpercent;

	@Column(name = "invoice_method")
	private String invoiceMethod;




	public Account(
			String partner,
			String salesId,
			String cardType,
			String cardNumber,
			String cardValidfrom,
			String cardExpiry,
			String switchNumber,
			String cardholderName,
			String saveCard,
			String billingCompany,
			String billingTelephone,
			String billingFax,
			String billingAddr1,
			String billingAddr2,
			String billingTown,
			String billingCounty,
			String billingCountry,
			String billingPostcode,
			String billingContact,
			String billingEmail,
			String billingEmailCc,
			String invoicePeriod,
			String paymentType,
			String vatNumber,
			String vatExempt,
			Integer priceBand,
			String goodCustomer,
			BigDecimal internationalDiscountpercent,
			BigDecimal companieshouseDiscountpercent,
			String invoiceMethod
			) {
		this.partner=partner;
		this.salesId=salesId;
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.cardValidfrom=cardValidfrom;
		this.cardExpiry=cardExpiry;
		this.switchNumber=switchNumber;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.billingCompany=billingCompany;
		this.billingTelephone=billingTelephone;
		this.billingFax=billingFax;
		this.billingAddr1=billingAddr1;
		this.billingAddr2=billingAddr2;
		this.billingTown=billingTown;
		this.billingCounty=billingCounty;
		this.billingCountry=billingCountry;
		this.billingPostcode=billingPostcode;
		this.billingContact=billingContact;
		this.billingEmail=billingEmail;
		this.billingEmailCc=billingEmailCc;
		this.invoicePeriod=invoicePeriod;
		this.paymentType=paymentType;
		this.vatNumber=vatNumber;
		this.vatExempt=vatExempt;
		this.priceBand=priceBand;
		this.goodCustomer=goodCustomer;
		this.internationalDiscountpercent=internationalDiscountpercent;
		this.companieshouseDiscountpercent=companieshouseDiscountpercent;
		this.invoiceMethod=invoiceMethod;
	}
	public Account(
			String account,
			String partner,
			String salesId,
			String cardType,
			String cardNumber,
			String cardValidfrom,
			String cardExpiry,
			String switchNumber,
			String cardholderName,
			String saveCard,
			String billingCompany,
			String billingTelephone,
			String billingFax,
			String billingAddr1,
			String billingAddr2,
			String billingTown,
			String billingCounty,
			String billingCountry,
			String billingPostcode,
			String billingContact,
			String billingEmail,
			String billingEmailCc,
			String invoicePeriod,
			String paymentType,
			String vatNumber,
			String vatExempt,
			Integer priceBand,
			String goodCustomer,
			BigDecimal internationalDiscountpercent,
			BigDecimal companieshouseDiscountpercent,
			String invoiceMethod
			) {
		this.account=account;		
		this.partner=partner;
		this.salesId=salesId;
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.cardValidfrom=cardValidfrom;
		this.cardExpiry=cardExpiry;
		this.switchNumber=switchNumber;
		this.cardholderName=cardholderName;
		this.saveCard=saveCard;
		this.billingCompany=billingCompany;
		this.billingTelephone=billingTelephone;
		this.billingFax=billingFax;
		this.billingAddr1=billingAddr1;
		this.billingAddr2=billingAddr2;
		this.billingTown=billingTown;
		this.billingCounty=billingCounty;
		this.billingCountry=billingCountry;
		this.billingPostcode=billingPostcode;
		this.billingContact=billingContact;
		this.billingEmail=billingEmail;
		this.billingEmailCc=billingEmailCc;
		this.invoicePeriod=invoicePeriod;
		this.paymentType=paymentType;
		this.vatNumber=vatNumber;
		this.vatExempt=vatExempt;
		this.priceBand=priceBand;
		this.goodCustomer=goodCustomer;
		this.internationalDiscountpercent=internationalDiscountpercent;
		this.companieshouseDiscountpercent=companieshouseDiscountpercent;
		this.invoiceMethod=invoiceMethod;		
	}
	public Account() {
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardValidfrom() {
		return cardValidfrom;
	}
	public void setCardValidfrom(String cardValidfrom) {
		this.cardValidfrom = cardValidfrom;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getSwitchNumber() {
		return switchNumber;
	}
	public void setSwitchNumber(String switchNumber) {
		this.switchNumber = switchNumber;
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

	public String getBillingCompany() {
		return billingCompany;
	}
	public void setBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
	}
	public String getBillingTelephone() {
		return billingTelephone;
	}
	public void setBillingTelephone(String billingTelephone) {
		this.billingTelephone = billingTelephone;
	}
	public String getBillingFax() {
		return billingFax;
	}
	public void setBillingFax(String billingFax) {
		this.billingFax = billingFax;
	}
	public String getBillingAddr1() {
		return billingAddr1;
	}
	public void setBillingAddr1(String billingAddr1) {
		this.billingAddr1 = billingAddr1;
	}
	public String getBillingAddr2() {
		return billingAddr2;
	}
	public void setBillingAddr2(String billingAddr2) {
		this.billingAddr2 = billingAddr2;
	}
	public String getBillingTown() {
		return billingTown;
	}
	public void setBillingTown(String billingTown) {
		this.billingTown = billingTown;
	}
	public String getBillingCounty() {
		return billingCounty;
	}
	public void setBillingCounty(String billingCounty) {
		this.billingCounty = billingCounty;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingPostcode() {
		return billingPostcode;
	}
	public void setBillingPostcode(String billingPostcode) {
		this.billingPostcode = billingPostcode;
	}
	public String getBillingContact() {
		return billingContact;
	}
	public void setBillingContact(String billingContact) {
		this.billingContact = billingContact;
	}
	public String getBillingEmail() {
		return billingEmail;
	}
	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}
	public String getBillingEmailCc() {
		return billingEmailCc;
	}
	public void setBillingEmailCc(String billingEmailCc) {
		this.billingEmailCc = billingEmailCc;
	}
	
	public String getInvoicePeriod() {
		return invoicePeriod;
	}
	public void setInvoicePeriod(String invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getVatExempt() {
		return vatExempt;
	}
	public void setVatExempt(String vatExempt) {
		this.vatExempt = vatExempt;
	}
	public Integer getPriceBand() {
		return priceBand;
	}
	public void setPriceBand(Integer priceBand) {
		this.priceBand = priceBand;
	}
	public String getGoodCustomer() {
		return goodCustomer;
	}
	public void setGoodCustomer(String goodCustomer) {
		this.goodCustomer = goodCustomer;
	}
	public BigDecimal getInternationalDiscountpercent() {
		return internationalDiscountpercent;
	}
	public void setInternationalDiscountpercent(BigDecimal internationalDiscountpercent) {
		this.internationalDiscountpercent = internationalDiscountpercent;
	}
	public BigDecimal getCompanieshouseDiscountpercent() {
		return companieshouseDiscountpercent;
	}
	public void setCompanieshouseDiscountpercent(BigDecimal companieshouseDiscountpercent) {
		this.companieshouseDiscountpercent = companieshouseDiscountpercent;
	}
	public String getInvoiceMethod() {
		return invoiceMethod;
	}
	public void setInvoiceMethod(String invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((billingAddr1 == null) ? 0 : billingAddr1.hashCode());
		result = prime * result + ((billingAddr2 == null) ? 0 : billingAddr2.hashCode());
		result = prime * result + ((billingCompany == null) ? 0 : billingCompany.hashCode());
		result = prime * result + ((billingContact == null) ? 0 : billingContact.hashCode());
		result = prime * result + ((billingCountry == null) ? 0 : billingCountry.hashCode());
		result = prime * result + ((billingCounty == null) ? 0 : billingCounty.hashCode());
		result = prime * result + ((billingEmail == null) ? 0 : billingEmail.hashCode());
		result = prime * result + ((billingEmailCc == null) ? 0 : billingEmailCc.hashCode());
		result = prime * result + ((billingFax == null) ? 0 : billingFax.hashCode());
		result = prime * result + ((billingPostcode == null) ? 0 : billingPostcode.hashCode());
		result = prime * result + ((billingTelephone == null) ? 0 : billingTelephone.hashCode());
		result = prime * result + ((billingTown == null) ? 0 : billingTown.hashCode());
		result = prime * result + ((cardExpiry == null) ? 0 : cardExpiry.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((cardValidfrom == null) ? 0 : cardValidfrom.hashCode());
		result = prime * result + ((cardholderName == null) ? 0 : cardholderName.hashCode());
		result = prime * result
				+ ((companieshouseDiscountpercent == null) ? 0 : companieshouseDiscountpercent.hashCode());
		result = prime * result + ((goodCustomer == null) ? 0 : goodCustomer.hashCode());
		result = prime * result
				+ ((internationalDiscountpercent == null) ? 0 : internationalDiscountpercent.hashCode());
		result = prime * result + ((invoiceMethod == null) ? 0 : invoiceMethod.hashCode());
		result = prime * result + ((invoicePeriod == null) ? 0 : invoicePeriod.hashCode());
		result = prime * result + ((partner == null) ? 0 : partner.hashCode());
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result + ((priceBand == null) ? 0 : priceBand.hashCode());
		result = prime * result + ((salesId == null) ? 0 : salesId.hashCode());
		result = prime * result + ((saveCard == null) ? 0 : saveCard.hashCode());
		result = prime * result + ((switchNumber == null) ? 0 : switchNumber.hashCode());
		result = prime * result + ((vatExempt == null) ? 0 : vatExempt.hashCode());
		result = prime * result + ((vatNumber == null) ? 0 : vatNumber.hashCode());
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
		Account other = (Account) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (billingAddr1 == null) {
			if (other.billingAddr1 != null)
				return false;
		} else if (!billingAddr1.equals(other.billingAddr1))
			return false;
		if (billingAddr2 == null) {
			if (other.billingAddr2 != null)
				return false;
		} else if (!billingAddr2.equals(other.billingAddr2))
			return false;
		if (billingCompany == null) {
			if (other.billingCompany != null)
				return false;
		} else if (!billingCompany.equals(other.billingCompany))
			return false;
		if (billingContact == null) {
			if (other.billingContact != null)
				return false;
		} else if (!billingContact.equals(other.billingContact))
			return false;
		if (billingCountry == null) {
			if (other.billingCountry != null)
				return false;
		} else if (!billingCountry.equals(other.billingCountry))
			return false;
		if (billingCounty == null) {
			if (other.billingCounty != null)
				return false;
		} else if (!billingCounty.equals(other.billingCounty))
			return false;
		if (billingEmail == null) {
			if (other.billingEmail != null)
				return false;
		} else if (!billingEmail.equals(other.billingEmail))
			return false;
		if (billingEmailCc == null) {
			if (other.billingEmailCc != null)
				return false;
		} else if (!billingEmailCc.equals(other.billingEmailCc))
			return false;
		if (billingFax == null) {
			if (other.billingFax != null)
				return false;
		} else if (!billingFax.equals(other.billingFax))
			return false;
		if (billingPostcode == null) {
			if (other.billingPostcode != null)
				return false;
		} else if (!billingPostcode.equals(other.billingPostcode))
			return false;
		if (billingTelephone == null) {
			if (other.billingTelephone != null)
				return false;
		} else if (!billingTelephone.equals(other.billingTelephone))
			return false;
		if (billingTown == null) {
			if (other.billingTown != null)
				return false;
		} else if (!billingTown.equals(other.billingTown))
			return false;
		if (cardExpiry == null) {
			if (other.cardExpiry != null)
				return false;
		} else if (!cardExpiry.equals(other.cardExpiry))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (cardValidfrom == null) {
			if (other.cardValidfrom != null)
				return false;
		} else if (!cardValidfrom.equals(other.cardValidfrom))
			return false;
		if (cardholderName == null) {
			if (other.cardholderName != null)
				return false;
		} else if (!cardholderName.equals(other.cardholderName))
			return false;
		if (companieshouseDiscountpercent == null) {
			if (other.companieshouseDiscountpercent != null)
				return false;
		} else if (!companieshouseDiscountpercent.equals(other.companieshouseDiscountpercent))
			return false;
		if (goodCustomer == null) {
			if (other.goodCustomer != null)
				return false;
		} else if (!goodCustomer.equals(other.goodCustomer))
			return false;
		if (internationalDiscountpercent == null) {
			if (other.internationalDiscountpercent != null)
				return false;
		} else if (!internationalDiscountpercent.equals(other.internationalDiscountpercent))
			return false;
		if (invoiceMethod == null) {
			if (other.invoiceMethod != null)
				return false;
		} else if (!invoiceMethod.equals(other.invoiceMethod))
			return false;
		if (invoicePeriod == null) {
			if (other.invoicePeriod != null)
				return false;
		} else if (!invoicePeriod.equals(other.invoicePeriod))
			return false;
		if (partner == null) {
			if (other.partner != null)
				return false;
		} else if (!partner.equals(other.partner))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (priceBand == null) {
			if (other.priceBand != null)
				return false;
		} else if (!priceBand.equals(other.priceBand))
			return false;
		if (salesId == null) {
			if (other.salesId != null)
				return false;
		} else if (!salesId.equals(other.salesId))
			return false;
		if (saveCard == null) {
			if (other.saveCard != null)
				return false;
		} else if (!saveCard.equals(other.saveCard))
			return false;
		if (switchNumber == null) {
			if (other.switchNumber != null)
				return false;
		} else if (!switchNumber.equals(other.switchNumber))
			return false;
		if (vatExempt == null) {
			if (other.vatExempt != null)
				return false;
		} else if (!vatExempt.equals(other.vatExempt))
			return false;
		if (vatNumber == null) {
			if (other.vatNumber != null)
				return false;
		} else if (!vatNumber.equals(other.vatNumber))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Account [account=" + account + ", partner=" + partner + ", salesId=" + salesId + ", cardType="
				+ cardType + ", cardNumber=" + cardNumber + ", cardValidfrom=" + cardValidfrom + ", cardExpiry="
				+ cardExpiry + ", switchNumber=" + switchNumber + ", cardholderName=" + cardholderName + ", saveCard="
				+ saveCard + ", billingCompany=" + billingCompany + ", billingTelephone=" + billingTelephone
				+ ", billingFax=" + billingFax + ", billingAddr1=" + billingAddr1 + ", billingAddr2=" + billingAddr2
				+ ", billingTown=" + billingTown + ", billingCounty=" + billingCounty + ", billingCountry="
				+ billingCountry + ", billingPostcode=" + billingPostcode + ", billingContact=" + billingContact
				+ ", billingEmail=" + billingEmail + ", billingEmailCc=" + billingEmailCc + ", invoicePeriod="
				+ invoicePeriod + ", paymentType=" + paymentType + ", vatNumber=" + vatNumber + ", vatExempt="
				+ vatExempt + ", priceBand=" + priceBand + ", goodCustomer=" + goodCustomer
				+ ", internationalDiscountpercent=" + internationalDiscountpercent + ", companieshouseDiscountpercent="
				+ companieshouseDiscountpercent + ", invoiceMethod=" + invoiceMethod + "]";
	}
	
	


}
