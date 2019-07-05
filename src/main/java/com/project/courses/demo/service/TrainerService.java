package com.project.courses.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Course;
import com.project.courses.demo.entity.CourseTrainer;
import com.project.courses.demo.entity.Trainer;
import com.project.courses.demo.model.CourseModel;
import com.project.courses.demo.model.TrainerModel;
import com.project.courses.demo.repo.CourseTrainerRepository;
import com.project.courses.demo.repo.CoursesRepository;
import com.project.courses.demo.repo.TrainerAllocationRepository;
import com.project.courses.demo.repo.TrainerRepository;
@Component
public class TrainerService {
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	private CoursesRepository courseRepository;
	@Autowired
	private CourseTrainerRepository courseTrainerRepository;
	@Autowired
	private TrainerAllocationRepository trainerAllocationRepository;
	public List<TrainerModel> getTrainers()
	{
		List<Trainer> trainers=(List<Trainer>) trainerRepository.findAll();
		List<TrainerModel> trainersDto=new ArrayList<>();
		for(Trainer trainer:trainers)
		{
			TrainerModel tm=new TrainerModel(trainer.getTrainer_id(), trainer.getTrainer_name(), new ArrayList<CourseModel>());
			List<CourseTrainer> courseTrainers=courseTrainerRepository.findByTrainer(trainer);
			for(CourseTrainer courseTrainer:courseTrainers)
			{
				CourseModel cm=new CourseModel();
				cm.setCourse_name(courseTrainer.getCourse().getCourse_name());
				cm.setCourse_id(courseTrainer.getCourse().getCourse_id());
				tm.getCourses().add(cm);
			}
			trainersDto.add(tm);
		}
		return trainersDto;
	}
	public Boolean addTrainer(TrainerModel trainerDto)
	{
		Trainer trainer=trainerRepository.findByTrainerName(trainerDto.getTrainerName().toLowerCase());
		if(trainer!=null)
		{
			return false;
		}
		else
		{
			trainer=new Trainer();
			trainer.setTrainer_name(trainerDto.getTrainerName().toLowerCase());
			List<CourseTrainer> courseTrainers=new ArrayList<>();
			for(CourseModel course:trainerDto.getCourses())
			{
				Course courseEntity=new Course();
				courseEntity.setCourse_id(course.getCourse_id());
				courseEntity.setCourse_name(course.getCourse_name());
				CourseTrainer courseTrainer=new CourseTrainer();
				courseTrainer.setCourse(courseEntity);
				courseTrainer.setTrainer(trainer);
				courseTrainers.add(courseTrainer);
			}
			trainerRepository.save(trainer);
			courseTrainerRepository.saveAll(courseTrainers);

			return true;
		}
	}
	public List<TrainerModel> getTrainersForCourse(int courseId)
	{
		List<TrainerModel> trainers=new ArrayList<>();
		Optional<Course> courseCheck=courseRepository.findById(courseId);
		if(courseCheck.isPresent())
		{
			Course course=courseCheck.get();
			List<CourseTrainer> courseTrainers=courseTrainerRepository.findByCourse(course);

			for(CourseTrainer courseTrainer:courseTrainers)
			{
				trainers.add(new TrainerModel(courseTrainer.getTrainer().getTrainer_id(), courseTrainer.getTrainer().getTrainer_name(),new ArrayList<>()));
			}
		}
		return trainers;
	}
	public  Boolean deleteTrainer(Integer trainerId)
	{
		Optional<Trainer> trainerCheck=trainerRepository.findById(trainerId);
		System.out.println(trainerCheck);
		if(trainerCheck.isPresent())
		{
			Trainer trainer=trainerCheck.get();
			if(trainerAllocationRepository.findByBackupTrainer(trainer).size()==0&&trainerAllocationRepository.findByTrainer(trainer).size()==0)
			{
				List<CourseTrainer> courseTrainers=courseTrainerRepository.findByTrainer(trainer);
				courseTrainerRepository.deleteAll(courseTrainers);
				System.out.println("Deletes Mapping");
				System.out.println(trainer);
				trainerRepository.delete(trainer);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public Boolean updateTrainer(TrainerModel trainerDto)
	{
		if(trainerDto.getTrainerId()==null)
		{
			return false;
		}
		else
		{
			Trainer trainer=new Trainer();
			trainer.setTrainer_name(trainerDto.getTrainerName());
			trainer.setTrainer_id(trainerDto.getTrainerId());

			if(trainerAllocationRepository.findByBackupTrainer(trainer).size()==0) 
			{
				courseTrainerRepository.deleteByTrainer(trainer);
				List<CourseTrainer> courseTrainers=new ArrayList<>();
				for(CourseModel course:trainerDto.getCourses())
				{
					Course courseEntity=new Course();
					courseEntity.setCourse_id(course.getCourse_id());
					courseEntity.setCourse_name(course.getCourse_name());
					CourseTrainer courseTrainer=new CourseTrainer();
					courseTrainer.setCourse(courseEntity);
					courseTrainer.setTrainer(trainer);
					courseTrainers.add(courseTrainer);
				}
				trainerRepository.save(trainer);
				courseTrainerRepository.saveAll(courseTrainers);
				return true;
			}
			else
			{
				return false;
			}
		}
	}

}
