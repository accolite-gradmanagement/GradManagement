package com.assessment.data.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class GradScore {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "score_id",unique=true, nullable = false)
	private int score_id;


//	@OneToMany(mappedBy = "grad_score")
//	@JoinColumn(name = "scoreEmployeeId", nullable = false,referencedColumnName = "employeeId")
//	@JoinTable(name = "grad_score",
//			joinColumns = @JoinColumn(
//					name = "employee_id",
//					referencedColumnName = "employee_id"
//			)
//	)
//	@OneToMany
//	private Set<GradEmployee> gradEmployee = new HashSet<>();




//	@OneToMany(mappedBy = "grad_score")
//	@JoinColumn(name = "scoreTestId", nullable = false,referencedColumnName = "testId")
//	@JoinTable(name = "grad_score",
//			joinColumns = @JoinColumn(
//					name = "test_id",
//					referencedColumnName = "test_id"
//			)
//	)
//	@OneToMany
//	private Set<GradTest> gradTest =  new HashSet<>();


	@OneToOne(optional = true)
	private  GradTest gradTest;


	@OneToOne(optional = true)
	private  GradEmployee gradEmployee;

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
	
//	public Integer getScore_id() {
//		return score_id;
//	}


//	public Set<GradEmployee> getGradEmployees() {
//		return gradEmployee;
//	}
//
//	public void setGradEmployee(Set<GradEmployee> gradEmployee) {
//		this.gradEmployee = gradEmployee;
//	}

//	public Set<GradTest> getGradTest() {
//		return gradTest;
//	}
//
//	public void setGradTest(Set<GradTest> gradTest) {
//		this.gradTest = gradTest;
//	}

	public GradTest getGradTest() {
		return gradTest;
	}

	public void setGradTest(GradTest gradTest) {
		this.gradTest = gradTest;
	}

	public GradEmployee getGradEmployee() {
		return gradEmployee;
	}

	public void setGradEmployee(GradEmployee gradEmployee) {
		this.gradEmployee = gradEmployee;
	}
}

