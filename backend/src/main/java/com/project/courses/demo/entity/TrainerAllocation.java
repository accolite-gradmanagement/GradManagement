package com.project.courses.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="trainer_allocation")
public class TrainerAllocation {

		public int getTrainer_allocation_id() {
		return trainer_allocation_id;
	}

	public void setTrainer_allocation_id(int trainer_allocation_id) {
		this.trainer_allocation_id = trainer_allocation_id;
	}

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

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

		@JsonSerialize
	 	@Id
		@GeneratedValue
		@Column(name="trainer_allocation_id")
		private int trainer_allocation_id;
	 
		@JsonSerialize
	 	@OneToOne
	    @JoinColumn(name = "course_id")
	    private Course course;

		@JsonSerialize
		@OneToOne
	    @JoinColumn(name = "trainer_id")
	    private Trainer trainer;
		
		@JsonSerialize
		@OneToOne
	    @JoinColumn(name = "backup_trainer_id")
	    private Trainer backupTrainer;
	    
		@JsonDeserialize
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="end_time")
	    private LocalDateTime end_time;
	    
		@JsonDeserialize
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name="start_time")
	    private LocalDateTime start_time;
		
		@JsonSerialize
		@Column(name="comment")
		private String comment;
		
		@JsonSerialize
		@ManyToOne
	    @JoinColumn(name = "batch_id")
	    private Batch batch;

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Trainer getBackupTrainer() {
			return backupTrainer;
		}

		public void setBackupTrainer(Trainer backupTrainer) {
			this.backupTrainer = backupTrainer;
		}

		public Batch getBatch() {
			return batch;
		}

		public void setBatch(Batch batch) {
			this.batch = batch;
		}

		@Override
		public String toString() {
			return "TrainerAllocation [trainer_allocation_id=" + trainer_allocation_id + ", course=" + course
					+ ", trainer=" + trainer + ", backup_trainer=" + backupTrainer + ", end_time=" + end_time
					+ ", start_time=" + start_time + "]";
		}

		public Trainer getBackup_trainer() {
			return backupTrainer;
		}

		public void setBackup_trainer(Trainer backup_trainer) {
			this.backupTrainer = backup_trainer;
		}

		
	    
	  
}
