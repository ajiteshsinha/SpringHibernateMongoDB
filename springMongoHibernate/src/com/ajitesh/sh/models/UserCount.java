package com.ajitesh.sh.models;

import java.io.Serializable;

public class UserCount implements Serializable{
	
	private static final long serialVersionUID = 8661543987252015859L;
	
	private String department;
	private String department1;
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment1() {
		return department1;
	}

	public void setDepartment1(String department1) {
		this.department1 = department1;
	}

}
