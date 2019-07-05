package com.project.courses.demo.model;

import java.util.List;

public class TrainerModel {
	private Integer trainerId;
	private String trainerName;
	private List<CourseModel> courses;	
	public TrainerModel(int trainerId, String trainerName, List<CourseModel> courses) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.courses = courses;
	}
	public Integer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public List<CourseModel> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseModel> courses) {
		this.courses = courses;
	}
	
}
