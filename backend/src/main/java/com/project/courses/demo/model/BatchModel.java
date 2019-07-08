package com.project.courses.demo.model;

import java.util.List;

import com.project.courses.demo.entity.TrainerAllocation;

public class BatchModel {
	private int batchId;
	private String batchName;
	private List<TrainerAllocation>  trainerAllocation;
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public List<TrainerAllocation> getTrainerAllocation() {
		return trainerAllocation;
	}
	public void setTrainerAllocation(List<TrainerAllocation> trainerAllocation) {
		this.trainerAllocation = trainerAllocation;
	}

}
