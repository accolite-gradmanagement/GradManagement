package com.assessment.data.model;

import com.assessment.data.entity.GradScore;

public class WrapperGradEmployeeScore {

	private GradScore gradScore;
//	private String gradEmployeeName;
//	private GradTest gradTest;
	
	public WrapperGradEmployeeScore(GradScore gradScore) {//,String gradEmployeeName,GradTest gradTest) {
//		this.gradEmployeeName = gradEmployeeName;
		this.gradScore = gradScore;
//		this.gradTest = gradTest;
	}

	public GradScore getGradScore() {
		return gradScore;
	}

//	public String getGradEmployeeName() {
//		return gradEmployeeName;
//	}
//
//
//	public GradTest getGradTest() {
//		return gradTest;
//	}


	
	
	
	
	
}
