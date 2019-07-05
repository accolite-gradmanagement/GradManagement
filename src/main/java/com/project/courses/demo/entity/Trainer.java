package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue
	@Column(name="trainer_id")
	private int trainerId;
	
	@Column(name="trainer_name")
	private String trainerName;
	
	
	
	public Trainer() {}

	public Trainer(String trainer_name) {
		this.trainerName = trainer_name;
		
	}

	
	

	public int getTrainer_id() {
		return trainerId;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainerId = trainer_id;
	}

	public String getTrainer_name() {
		return trainerName;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainerName = trainer_name;
	}

	@Override
	public String toString() {
		return "trainer [trainer_id=" + trainerId + ", trainer_name=" + trainerName +"]";
	}
	
}
