package com.armadillo.api.clientservice.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "manager")
public class Manager implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "password")
	private String password;

	


	public Manager(
			String id,
			String password
			) {
		this.id=id;
		this.password=password;
	}
	public Manager() {
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
		Manager other = (Manager) obj;
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
		return "Manager [id=" + id + ", password=" + password + "]";
	}
	
	


}
