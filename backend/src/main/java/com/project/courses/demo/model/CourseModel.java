package com.project.courses.demo.model;

public class CourseModel {
	
	private int course_id;
	private String course_name;

	/*
	 * private int trainer_id; private String comment;
	 */
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	/*
	 * public int getTrainer_id() { return trainer_id; } public void
	 * setTrainer_id(int trainer_id) { this.trainer_id = trainer_id; } public String
	 * getComment() { return comment; } public void setComment(String comment) {
	 * this.comment = comment; }
	 */
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
