package com.project.courses.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Batch;
import com.project.courses.demo.model.BatchModel;
import com.project.courses.demo.repo.BatchRepository;

@Component
public class BatchService {
	@Autowired
	private BatchRepository batchRepository;
	public Batch addBatch(BatchModel batchDto)
	{
		Batch batch=batchRepository.findByBatchName(batchDto.getBatchName());
		if(batch==null)
		{
			batch=new Batch();
			batch.setBatchName(batchDto.getBatchName());
			batchRepository.save(batch);
			return batch;
		}
		else
		{
			return null;
		}
		
	}
	public List<Batch> getBatches()
	{
		List<Batch> batches=(List<Batch>)batchRepository.findAll();
		return batches;
	}

}
