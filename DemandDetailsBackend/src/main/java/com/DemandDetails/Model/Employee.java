package com.DemandDetails.Model;

public class Employee {

	private int EMP_ID;
	private String EMP_NAME;
	private String ROLE;

	public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}

	public Employee(int eMP_ID, String eMP_NAME, String rOLE) {
		super();
		EMP_ID = eMP_ID;
		EMP_NAME = eMP_NAME;
		ROLE = rOLE;
	}

	public Employee() {
		super();
	}

}
