package com.assessment.data.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class GradScore {

	@Id
	private Integer score_id;
	
	
	@OneToOne
	@JoinColumn(name = "scoreEmployeeId", nullable = false,referencedColumnName = "employeeId")
	private GradEmployee gradEmployee;
	

	@OneToOne
	@JoinColumn(name = "scoreTestId", nullable = false,referencedColumnName = "testId")
	private GradTest gradTest;
	
	private int score;
	private int correctQuestions;
	private int incorrectQuestions;

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCorrectQuestions() {
		return correctQuestions;
	}
	public void setCorrectQuestions(int correctQuestions) {
		this.correctQuestions = correctQuestions;
	}
	public int getIncorrectQuestions() {
		return incorrectQuestions;
	}
	public void setIncorrectQuestions(int incorrectQuestions) {
		this.incorrectQuestions = incorrectQuestions;
	}
	
	public Integer getScore_id() {
		return score_id;
	}
	public GradEmployee getGradEmployee() {
		return gradEmployee;
	}
	public GradTest getGradTest() {
		return gradTest;
	}
	

	
	
	
	
}

