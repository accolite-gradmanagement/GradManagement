package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_trainer")
public class CourseTrainer {
	
	@OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

	
    @OneToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
	
    @Id
	@GeneratedValue
	@Column(name="course_trainer_id")
	private int course_trainer_id;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public int getCourse_trainer_id() {
		return course_trainer_id;
	}

	public void setCourse_trainer_id(int course_trainer_id) {
		this.course_trainer_id = course_trainer_id;
	}	
    
    
}
