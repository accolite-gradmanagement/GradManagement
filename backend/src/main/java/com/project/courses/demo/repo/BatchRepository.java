package com.project.courses.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.courses.demo.entity.Batch;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Integer> {
	Batch findByBatchId(int batch_id);
	Batch findByBatchName(String batchName);
}
