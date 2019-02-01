package com.armadillo.api.clientservice.domain;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Objects;


/**
 */
@Entity
@Table (name="systemcode")
public class SystemCode implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
    @Column (name="systemcodeid")	
    private Integer systemCodeId;

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
	
	
	
	

    public SystemCode(
    		Integer systemCodeId, 
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
    		String description    		
    		) {
        this.systemCodeId = systemCodeId;
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
    }
    public SystemCode(
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
    		String description     		
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
    }
    public SystemCode(
    		String codeType, 
    		String codeValue,
    		String createUserId,
    		java.util.Date createDate,
    		String createTime,
    		java.util.Date systemLogDate,
    		String systemLogAction,
    		String systemLogProgram,
    		String systemLogTime,
    		String systemLogUserid,
    		String description     		
    		) {
        this.codeType = codeType;
        this.codeValue = codeValue;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.createTime = createTime;
        this.systemLogDate = systemLogDate;
        this.systemLogAction = systemLogAction;
        this.systemLogProgram = systemLogProgram;
        this.systemLogTime = systemLogTime;
        this.systemLogUserid = systemLogUserid;
        this.description = description;        
    }
    
    public SystemCode() {
    }
    
    
    
	public Integer getSystemCodeId() {
		return systemCodeId;
	}
	public void setSystemCodeId(Integer systemCodeId) {
		this.systemCodeId = systemCodeId;
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
	
	
	@Override
	public String toString() {
		return "SystemCode [systemCodeId=" + systemCodeId + ", codeType=" + codeType + ", codeValue=" + codeValue
				+ ", createUserId=" + createUserId + ", createDate=" + createDate + ", createTime=" + createTime
				+ ", isDeleted=" + isDeleted + ", deleteDate=" + deleteDate + ", deleteTime=" + deleteTime
				+ ", systemLogDate=" + systemLogDate + ", systemLogAction=" + systemLogAction + ", systemLogProgram="
				+ systemLogProgram + ", systemLogTime=" + systemLogTime + ", systemLogUserid=" + systemLogUserid
				+ ", xlock=" + xlock + ", isActive=" + isActive 
				 + ", description=" + description				
				+ "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(
		        systemCodeId,
		        codeType,
		        codeValue,
		        createUserId,
		        createDate,
		        createTime,
		        isDeleted,
		        deleteDate,
		        deleteTime,
		        systemLogDate,
		        systemLogAction,
		        systemLogProgram ,
		        systemLogTime ,
		        systemLogUserid,
		        xlock,
		        isActive,
		        description
				);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemCode other = (SystemCode) obj;
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
		if (systemCodeId == null) {
			if (other.systemCodeId != null)
				return false;
		} else if (!systemCodeId.equals(other.systemCodeId))
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
		if (description == null) {
			if (other.description!= null)
				return false;
		} else if (!description.equals(other.description))
			return false;		
		return true;
	}


    
	
}
