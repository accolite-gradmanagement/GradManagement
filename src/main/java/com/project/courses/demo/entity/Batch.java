package com.project.courses.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@GeneratedValue
	@Column(name="batch_id")
	private int batchId;
	
	@Column(name="batch_name")
	private String batchName;

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
}
