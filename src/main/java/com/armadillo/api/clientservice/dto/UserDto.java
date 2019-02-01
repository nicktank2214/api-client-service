package com.armadillo.api.clientservice.dto;


import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;



/**
 * Data Transfer Object for users
 */
public class UserDto {

	
    @JsonProperty("user_id")
    private Integer userId;

    
    @Size(max = 200)
    @JsonProperty("password")
    private String password;

    @Size(max = 50)
    @JsonProperty("user_name")
    private String userName;

    @Size(max = 200)
    @JsonProperty("first_name")
    private String firstName;
	
    @Size(max = 200)
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("role_id")
    private Integer roleId;

    @JsonProperty("department_id")
    private Integer departmentId;

    @JsonProperty("disabled_flag")
    private Integer disabledFlag;

    @JsonProperty("active_flag")
    private Integer activeFlag;
    
    @JsonProperty("user_roles")    
	private Set<UserRoleDto> userRoles;
	
	
    
	public UserDto(Integer userId, String password, String userName, String firstName, String lastName, Integer roleId,
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
	public UserDto(String password, String userName, String firstName, String lastName, Integer roleId,
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
	protected UserDto() {
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
	
	
	public Set<UserRoleDto> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleDto> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", roleId=" + roleId + ", departmentId=" + departmentId
				+ ", disabledFlag=" + disabledFlag +  ", activeFlag=" + activeFlag +"]";
	}
  

	
}
