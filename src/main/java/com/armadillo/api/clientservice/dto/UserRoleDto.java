package com.armadillo.api.clientservice.dto;



import com.armadillo.api.clientservice.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 */
public class UserRoleDto {


    @JsonProperty("user_role_id")
    private Integer userRoleId;


    @JsonProperty("user_id")
    private Integer userId;
    
    
    @JsonProperty("role")	
    private String role;

    
    @JsonProperty("user")	
    private User user;
    



	public UserRoleDto(Integer userRoleId, Integer userId, String role) {
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.role = role;		
	}
	public UserRoleDto(Integer userId, String role) {
		this.userId = userId;
		this.role = role;		
	}
	public UserRoleDto() {
	}
	
	
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", role=" + role + "]";
	}
	


	
}
