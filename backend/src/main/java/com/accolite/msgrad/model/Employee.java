package com.accolite.msgrad.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	String emailId;
	String password;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
