package com.assessment.data.model;


import javax.persistence.*;


@Entity
public class GradScore {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Basic(optional = false)
	@Column(unique=true, nullable = false)
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


	@OneToOne
	@JoinColumn(name="test_id")
	private  GradTest gradTest;


	@OneToOne
	@JoinColumn(name="employee_id")
	private  GradEmployee gradEmployee;

	private int score;
	private int correctQuestions;
	
	


	private float successPercentage;

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


	public float getSuccessPercentage() {
		return successPercentage;
	}

	public void setSuccessPercentage(float successPercentage) {
		this.successPercentage = successPercentage;
	}

	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	

}


