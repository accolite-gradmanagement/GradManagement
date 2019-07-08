package com.accolite.grads.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="grad_details")
public class Grad {
	private @Id @GeneratedValue Long id;
	
	public Grad() {
		
	}
	
	public Grad(@NotNull String employeeCode, @NotNull String name, @NotNull String email, @NotNull String college,
			@NotNull String location, @NotNull String dateOfJoiningReconfirmation,@NotNull String course, @NotNull String branch, @NotNull Float cgpa,
			@NotNull String personalNumber, @NotNull String personalEmail, @NotNull Date dob,
			@NotNull String currentPlace, @NotNull String cvLink) {
		super();
		this.employeeCode = employeeCode;
		this.name = name;
		this.email = email;
		this.college = college;
		this.location = location;
		this.dateOfJoiningReconfirmation = dateOfJoiningReconfirmation;
		this.course = course;
		this.branch = branch;
		this.cgpa = cgpa;
		this.personalNumber = personalNumber;
		this.personalEmail = personalEmail;
		this.dob = dob;
		this.currentPlace = currentPlace;
		this.cvLink = cvLink;
	}

	public String getDateOfJoiningReconfirmation() {
		return dateOfJoiningReconfirmation;
	}

	@NotNull 
	@Column(name="emp_code") 
	private String employeeCode;
	
	private @NotNull String name;
	private @NotNull String email;
	private @NotNull String college;
	
	@NotNull 
	@Column(name="location_preference") 
	private String location;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joining")
	private Date joiningDate;
	
	private String batch;
	
	@Column(name="doj_reconfirmation")
	private String dateOfJoiningReconfirmation;
	
	private String remarks;
	
	private @NotNull String course;
	private @NotNull String branch;
	
	@NotNull 
	@Column(name="current_cgpa")
	private Float cgpa;
	
	@NotNull 
	@Column(name="personal_contact_number")
	private String personalNumber;
	
	@NotNull
	@Column(name="personal_email_id")
	private String personalEmail;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dob;
	
	private String nativePlace;
	
	private @NotNull String currentPlace;
	
	@Column(name="parent_contact_number")
	private String parentContact;
	
	@Column(name="parent_postal_address")
	private String parentAddress;
	
	@NotNull
	@Column(name="link_to_cv")
	private String cvLink;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personalEmail == null) ? 0 : personalEmail.hashCode());
		result = prime * result + ((personalNumber == null) ? 0 : personalNumber.hashCode());
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
		Grad other = (Grad) obj;
		if (personalEmail == null) {
			if (other.personalEmail != null)
				return false;
		} else if (!personalEmail.equals(other.personalEmail))
			return false;
		if (personalNumber == null) {
			if (other.personalNumber != null)
				return false;
		} else if (!personalNumber.equals(other.personalNumber))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String isDateOfJoiningConfirmation() {
		return dateOfJoiningReconfirmation;
	}

	public void setDateOfJoiningReconfirmation(String dateOfJoiningReconfirmation) {
		this.dateOfJoiningReconfirmation = dateOfJoiningReconfirmation;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Float getCgpa() {
		return cgpa;
	}

	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(String currentPlace) {
		this.currentPlace = currentPlace;
	}

	public String getParentContact() {
		return parentContact;
	}

	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}

	public String getParentAddress() {
		return parentAddress;
	}

	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress;
	}

	public String getCvLink() {
		return cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

	@Override
	public String toString() {
		return "Grad [EmployeeCode=" + this.employeeCode + ", name=" + name + "]";
	}
}
