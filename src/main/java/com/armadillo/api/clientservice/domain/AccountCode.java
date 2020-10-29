package com.armadillo.api.clientservice.domain;

import javax.persistence.*;


import java.io.Serializable;


/**
 */
@Entity
@Table (name="accountcode")
public class AccountCode implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
    @Column (name="accountcodeid")	
    private Integer accountCodeId;

	@Column (name="account")
    private String account;
	
	@Column (name="codetype")
    private String codeType;

	@Column (name="codevalue")
    private String codeValue;
	
	@Column (name="createuserid")
    private String createUserId;
	
	@Column (name="createdate")
    private java.util.Date createDate;
	
	@Column (name="createtime")
    private String createTime;

	@Column (name="isdeleted")	
	private Integer isDeleted;
	
	@Column (name="deletedate")
    private java.util.Date deleteDate;
	
	@Column (name="deletetime")
    private String deleteTime;
	
	@Column (name="systemlogdate")
    private java.util.Date systemLogDate;
	
	@Column (name="systemlogaction")
    private String systemLogAction;
	
	@Column (name="systemlogprogram")
    private String systemLogProgram;
	
	@Column (name="systemlogtime")
    private String systemLogTime;
	
	@Column (name="systemloguserid")
    private String systemLogUserid;
	
	@Column (name="xlock")
    private String xlock;
	
	@Column (name="isactive")	
	private Integer isActive;
	
	@Column (name="description")
    private String description;
	
	
	
	

    public AccountCode(
    		Integer accountCodeId, 
    		String codeType, 
    		String codeValue,
    		String createUserId,
    		java.util.Date createDate,
    		String createTime,
    		Integer isDeleted,
    		java.util.Date deleteDate,
    		String deleteTime,
    		java.util.Date systemLogDate,
    		String systemLogAction,
    		String systemLogProgram,
    		String systemLogTime,
    		String systemLogUserid,
    		String xlock,
    		Integer isActive,
    		String description,
    		String account       		
    		) {
        this.accountCodeId = accountCodeId;
        this.codeType = codeType;
        this.codeValue = codeValue;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.deleteDate = deleteDate;
        this.deleteTime = deleteTime;
        this.systemLogDate = systemLogDate;
        this.systemLogAction = systemLogAction;
        this.systemLogProgram = systemLogProgram;
        this.systemLogTime = systemLogTime;
        this.systemLogUserid = systemLogUserid;
        this.xlock = xlock;
        this.isActive = isActive;
        this.description = description;
        this.account = account;             
    }
    public AccountCode(
    		String codeType, 
    		String codeValue,
    		String createUserId,
    		java.util.Date createDate,
    		String createTime,
    		Integer isDeleted,
    		java.util.Date deleteDate,
    		String deleteTime,
    		java.util.Date systemLogDate,
    		String systemLogAction,
    		String systemLogProgram,
    		String systemLogTime,
    		String systemLogUserid,
    		String xlock,
    		Integer isActive,
    		String description,
    		String account        		
    		) {
        this.codeType = codeType;
        this.codeValue = codeValue;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.deleteDate = deleteDate;
        this.deleteTime = deleteTime;
        this.systemLogDate = systemLogDate;
        this.systemLogAction = systemLogAction;
        this.systemLogProgram = systemLogProgram;
        this.systemLogTime = systemLogTime;
        this.systemLogUserid = systemLogUserid;
        this.xlock = xlock;
        this.isActive = isActive;
        this.description = description;  
        this.account = account;              
    }
    public AccountCode(
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
    
    public AccountCode() {
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
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public java.util.Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(java.util.Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public java.util.Date getSystemLogDate() {
		return systemLogDate;
	}
	public void setSystemLogDate(java.util.Date systemLogDate) {
		this.systemLogDate = systemLogDate;
	}
	public String getSystemLogAction() {
		return systemLogAction;
	}
	public void setSystemLogAction(String systemLogAction) {
		this.systemLogAction = systemLogAction;
	}
	public String getSystemLogProgram() {
		return systemLogProgram;
	}
	public void setSystemLogProgram(String systemLogProgram) {
		this.systemLogProgram = systemLogProgram;
	}
	public String getSystemLogTime() {
		return systemLogTime;
	}
	public void setSystemLogTime(String systemLogTime) {
		this.systemLogTime = systemLogTime;
	}
	public String getSystemLogUserid() {
		return systemLogUserid;
	}
	public void setSystemLogUserid(String systemLogUserid) {
		this.systemLogUserid = systemLogUserid;
	}
	public String getXlock() {
		return xlock;
	}
	public void setXlock(String xlock) {
		this.xlock = xlock;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((accountCodeId == null) ? 0 : accountCodeId.hashCode());
		result = prime * result + ((codeType == null) ? 0 : codeType.hashCode());
		result = prime * result + ((codeValue == null) ? 0 : codeValue.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime * result + ((deleteDate == null) ? 0 : deleteDate.hashCode());
		result = prime * result + ((deleteTime == null) ? 0 : deleteTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((systemLogAction == null) ? 0 : systemLogAction.hashCode());
		result = prime * result + ((systemLogDate == null) ? 0 : systemLogDate.hashCode());
		result = prime * result + ((systemLogProgram == null) ? 0 : systemLogProgram.hashCode());
		result = prime * result + ((systemLogTime == null) ? 0 : systemLogTime.hashCode());
		result = prime * result + ((systemLogUserid == null) ? 0 : systemLogUserid.hashCode());
		result = prime * result + ((xlock == null) ? 0 : xlock.hashCode());
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
		AccountCode other = (AccountCode) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountCodeId == null) {
			if (other.accountCodeId != null)
				return false;
		} else if (!accountCodeId.equals(other.accountCodeId))
			return false;
		if (codeType == null) {
			if (other.codeType != null)
				return false;
		} else if (!codeType.equals(other.codeType))
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUserId == null) {
			if (other.createUserId != null)
				return false;
		} else if (!createUserId.equals(other.createUserId))
			return false;
		if (deleteDate == null) {
			if (other.deleteDate != null)
				return false;
		} else if (!deleteDate.equals(other.deleteDate))
			return false;
		if (deleteTime == null) {
			if (other.deleteTime != null)
				return false;
		} else if (!deleteTime.equals(other.deleteTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (systemLogAction == null) {
			if (other.systemLogAction != null)
				return false;
		} else if (!systemLogAction.equals(other.systemLogAction))
			return false;
		if (systemLogDate == null) {
			if (other.systemLogDate != null)
				return false;
		} else if (!systemLogDate.equals(other.systemLogDate))
			return false;
		if (systemLogProgram == null) {
			if (other.systemLogProgram != null)
				return false;
		} else if (!systemLogProgram.equals(other.systemLogProgram))
			return false;
		if (systemLogTime == null) {
			if (other.systemLogTime != null)
				return false;
		} else if (!systemLogTime.equals(other.systemLogTime))
			return false;
		if (systemLogUserid == null) {
			if (other.systemLogUserid != null)
				return false;
		} else if (!systemLogUserid.equals(other.systemLogUserid))
			return false;
		if (xlock == null) {
			if (other.xlock != null)
				return false;
		} else if (!xlock.equals(other.xlock))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "AccountCode [accountCodeId=" + accountCodeId + ", account=" + account + ", codeType=" + codeType
				+ ", codeValue=" + codeValue + ", createUserId=" + createUserId + ", createDate=" + createDate
				+ ", createTime=" + createTime + ", isDeleted=" + isDeleted + ", deleteDate=" + deleteDate
				+ ", deleteTime=" + deleteTime + ", systemLogDate=" + systemLogDate + ", systemLogAction="
				+ systemLogAction + ", systemLogProgram=" + systemLogProgram + ", systemLogTime=" + systemLogTime
				+ ", systemLogUserid=" + systemLogUserid + ", xlock=" + xlock + ", isActive=" + isActive
				+ ", description=" + description + "]";
	}		
	

    
	
}
