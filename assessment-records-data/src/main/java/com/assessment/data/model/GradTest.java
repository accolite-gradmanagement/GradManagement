package com.assessment.data.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class GradTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer testId;
	
	private String testName;
	private String batchName;

	private int totalQuestions;

	
	
	public GradTest(Integer testId, String testName,int totalQuestions) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.totalQuestions = totalQuestions;
	}
	
	public GradTest() {
		
	}

	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}


	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}


	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
}


