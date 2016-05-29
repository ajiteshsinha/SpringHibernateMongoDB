package com.ajitesh.sh.models;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class UserMaster implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4878446925795437472L;
	
	private  String userName;
	private String password;
	
	
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
	
}
