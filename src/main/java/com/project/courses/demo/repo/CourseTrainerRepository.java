package com.project.courses.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.courses.demo.entity.Course;
import com.project.courses.demo.entity.CourseTrainer;
import com.project.courses.demo.entity.Trainer;

public interface CourseTrainerRepository extends CrudRepository<CourseTrainer,Integer> {
	public List<CourseTrainer> findByTrainer(Trainer trainer);
	public List<CourseTrainer> findByCourse(Course course);
	public Boolean deleteByTrainer(Trainer trainer);

}
