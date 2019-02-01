package com.armadillo.api.clientservice.domain;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


/**
 */
@Entity
@Table (name="users")
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column (name="userid")	
	private Integer userId;


	@Column (name="password")	
	private String password;


	@Column (name="username")	
	private String userName;


	@Column (name="firstname")	
	private String firstName;


	@Column (name="lastname")	
	private String lastName;


	@Column (name="roleid")	
	private Integer roleId;


	@Column (name="departmentid")	
	private Integer departmentId;


	@Column (name="disabledflag")	
	private Integer disabledFlag;


	@Column (name="activeflag")	
	private Integer activeFlag;


	/** remove bidirectional mapping and replace with unidirectional 
	 * - this is to fix the problem with PUT update not working 
	 */
	//@OneToMany(fetch = FetchType.LAZY,mappedBy="user",cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name = "userid", insertable=false, updatable=false)		
    private Set<UserRole> userRoles;
    
    

	public User(Integer userId, String password, String userName, String firstName, String lastName, Integer roleId,
			Integer departmentId, Integer disabledFlag, Integer activeFlag) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.disabledFlag = disabledFlag;
		this.activeFlag = activeFlag;		
	}
	public User(String password, String userName, String firstName, String lastName, Integer roleId,
			Integer departmentId, Integer disabledFlag, Integer activeFlag) {
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.disabledFlag = disabledFlag;
		this.activeFlag = activeFlag;				
	}
	public User() {
	}




	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getDisabledFlag() {
		return disabledFlag;
	}
	public void setDisabledFlag(Integer disabledFlag) {
		this.disabledFlag = disabledFlag;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}




	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, password, firstName, lastName, roleId, departmentId, disabledFlag, activeFlag);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (disabledFlag == null) {
			if (other.disabledFlag != null)
				return false;
		} else if (!disabledFlag.equals(other.disabledFlag))
			return false;
		if (activeFlag == null) {
			if (other.activeFlag != null)
				return false;
		} else if (!activeFlag.equals(other.activeFlag))
			return false;		
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", roleId=" + roleId + ", departmentId=" + departmentId
				+ ", disabledFlag=" + disabledFlag + ", activeFlag=" + activeFlag+ "]";
	}



}
