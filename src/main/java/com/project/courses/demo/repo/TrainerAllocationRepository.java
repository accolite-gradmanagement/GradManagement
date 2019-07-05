package com.project.courses.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.courses.demo.entity.Batch;
import com.project.courses.demo.entity.Trainer;
import com.project.courses.demo.entity.TrainerAllocation;
@Repository
public interface TrainerAllocationRepository  extends CrudRepository<TrainerAllocation, Integer>{
	List<TrainerAllocation> findByBackupTrainer(Trainer backupTrainer);
	List<TrainerAllocation> findByBatch(Batch batch);
	List<TrainerAllocation> findByTrainer(Trainer trainer);
	
}
