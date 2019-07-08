package com.project.courses.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Batch;
import com.project.courses.demo.entity.Course;
import com.project.courses.demo.entity.Trainer;
import com.project.courses.demo.entity.TrainerAllocation;
import com.project.courses.demo.model.BatchModel;
import com.project.courses.demo.model.Timesheet;
import com.project.courses.demo.repo.BatchRepository;
import com.project.courses.demo.repo.CoursesRepository;
import com.project.courses.demo.repo.TrainerAllocationRepository;
import com.project.courses.demo.repo.TrainerRepository;

@Component
public class TrainerAllocationService {

	@Autowired
	TrainerAllocationRepository repository;
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	CoursesRepository coursesRepository;
	@Autowired
	BatchRepository batchRepository;

	public List<TrainerAllocation> getTimesheet() {
		return (List<TrainerAllocation>) repository.findAll();
	}
	public BatchModel getTimesheetByBatch(int batchId)
	{
		Batch batch=batchRepository.findByBatchId(batchId);
		if(batch==null)
		{
			return null;
		}
		else
		{
			List<TrainerAllocation> trainerAllocation=repository.findByBatch(batch);
			BatchModel batchModel=new BatchModel();
			batchModel.setBatchId(batchId);
			batchModel.setBatchName(batch.getBatchName());
			batchModel.setTrainerAllocation(trainerAllocation);
			return batchModel;
		}
	}

	public void addTimesheet(List<Timesheet> dto) {

		for (Timesheet c : dto) {
			repository.save(toEntity(c));

		}

	}
	
	public boolean udateTimesheet(List<Timesheet> dto,int batchId) {
		Batch batch=batchRepository.findByBatchId(batchId);
		if(batch==null)
		{
			return false;
		}
		else
		{
			System.out.println("Abc");
			List<TrainerAllocation> trainerAllocations=repository.findByBatch(batch);
			repository.deleteAll(trainerAllocations);
			System.out.println("Deleted");
			for (Timesheet c : dto) 
			{
				repository.save(toEntity(c));

			}
			return true;
		}


	}

	private TrainerAllocation toEntity(Timesheet cto) {

		TrainerAllocation entity = new TrainerAllocation();
//		CoursesService c = new CoursesService();

		// Course course=c.getCoursesById(cto.getCourse_id());
		Optional<Course> optionalCourse = coursesRepository.findById(cto.getCourse_id());

		Course course = optionalCourse
				.orElseThrow(() -> new CourseNotFoundException("Couldn't find a course with id: "));

		entity.setCourse(course);
		Trainer trainer = trainerRepository.findByTrainerId(cto.getTrainer_id());
		entity.setTrainer(trainer);
		Trainer backupTrainer = trainerRepository.findByTrainerId(cto.getBackup_trainer_id());
		entity.setBackup_trainer(backupTrainer);
		
		System.out.println("********BatchId******* "+cto.getBatch_id());
		
		Batch batch = batchRepository.findByBatchId(cto.getBatch_id());
		entity.setBatch(batch);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime lst = LocalDateTime.parse(cto.getStartTime(), f);
		entity.setStart_time(lst);

		LocalDateTime ldt = LocalDateTime.parse(cto.getEndTime(), f);
		entity.setEnd_time(ldt);

		entity.setComment(cto.getComment());

		return entity;

	}

	public void updateTimesheet(Timesheet cto) {
		TrainerAllocation trainerAllocation = toEntity(cto);
		repository.save(trainerAllocation);

	}

	public TrainerAllocation getById(int id) {
		return repository.findById(id).get();
	}

	public void deleteTimetable(int id) {
		repository.deleteById(id);

	}

}
