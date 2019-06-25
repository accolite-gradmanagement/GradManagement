package com.DemandDetails.Model;

public class Employee {

	private int id;
	private String employeeName;
	private String employeeRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Employee(int id, String employeeName, String employeeRole) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeRole = employeeRole;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeRole=" + employeeRole + "]";
	}

}
