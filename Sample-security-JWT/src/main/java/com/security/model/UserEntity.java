package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class UserEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String password;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	

}
