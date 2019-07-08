package com.assessment.data.model;

import javax.persistence.*;

@Entity
public class GradEmployee {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	private String employeeName;
	private String batchName;
	private int year;
	private long contactNo;
	private String location;

//	@ManyToOne
//	private GradScore gradScore;

	public GradEmployee() {
		
	}
	
	public GradEmployee(String employeeName, Integer employeeId, String batchName, int year, long contactNo,String location) {
		this.employeeName  =employeeName;
		this.employeeId = employeeId;
		this.batchName = batchName;
		this.year = year;
		this.contactNo = contactNo;
		this.location = location;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
