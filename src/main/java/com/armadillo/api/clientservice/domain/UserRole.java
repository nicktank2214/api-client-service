package com.armadillo.api.clientservice.domain;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Objects;


/**
 */
@Entity
@Table (name="userrole")
public class UserRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
    @Column (name="userroleid")	
    private Integer userRoleId;


    @Column (name="userid")	
    private Integer userId;
    
    
	@Column (name="role")	
    private String role;

	

/*    @ManyToOne()
    @JoinColumn(name = "userid", insertable=false, updatable=false)
    private User user;*/
    
    


	public UserRole(Integer userRoleId, Integer userId, String role) {
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.role = role;		
	}
	public UserRole(Integer userId, String role) {
		this.userId = userId;
		this.role = role;		
	}
	public UserRole() {
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
	

/*	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	
	
	
	@Override
	public int hashCode() {
        return Objects.hash(userRoleId, userId, role);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", role=" + role + "]";
	}
	
	
	
	

		 
	


	
}
