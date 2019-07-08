package com.project.courses.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.courses.demo.entity.Batch;
import com.project.courses.demo.model.BatchModel;
import com.project.courses.demo.service.BatchService;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/batch")
public class BatchController {
	@Autowired
	BatchService batchService;
	
	@PostMapping
	ResponseEntity<Batch> addBatch(@RequestBody BatchModel batchDto)
	{
		
		Batch batch=batchService.addBatch(batchDto);
		if(batch==null)
		{
			return new ResponseEntity<Batch>(HttpStatus.CONFLICT);
		}
		else
		{
			return new ResponseEntity<Batch>(batch,HttpStatus.OK);
		}
	}
	@GetMapping
	ResponseEntity<List<Batch>> getBatches()
	{
		List<Batch> batches= batchService.getBatches();
		return new ResponseEntity<List<Batch>>(batches,HttpStatus.OK);
		
	}

}
