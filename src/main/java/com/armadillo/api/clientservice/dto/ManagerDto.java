package com.armadillo.api.clientservice.dto;




import com.fasterxml.jackson.annotation.JsonProperty;






/**
 * Data Transfer Object 
 */
public class ManagerDto {

	
	
	@JsonProperty("id")
	private String id;

	@JsonProperty("password")
	private String password;

   
    
	public ManagerDto(
			String id,
			String password
			) {
		this.id=id;
		this.password=password;
	}
	protected ManagerDto() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		ManagerDto other = (ManagerDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "ManagerDto [id=" + id + ", password=" + password + "]";
	}
	

	
}
