package com.project.courses.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.courses.demo.entity.Course;
import com.project.courses.demo.model.CourseModel;
import com.project.courses.demo.repo.CourseTrainerRepository;
import com.project.courses.demo.repo.CoursesRepository;

@Component
public class CoursesService {
	@Autowired CoursesRepository repository;


	public void add(List<CourseModel> dto) {

		for(CourseModel c : dto) {
			repository.save(toEntity(c));

		}
	}
	public boolean addCourse(CourseModel courseDto)
	{
		Course course=repository.findByCourseName(courseDto.getCourse_name().toLowerCase());
		if(course!=null)
		{
			return false;
		}
		else
		{
			repository.save(toEntity(courseDto));
			return true;
		}
	}



	public List<Course> getCourses() {
		return (List<Course>) repository.findAll();

	}

	public Course getCoursesById(int id) {

		Optional<Course> optionalCourse = repository.findById(id);

		return optionalCourse.orElseThrow(() -> new CourseNotFoundException("Couldn't find a course with id: " + id));

	}

	private Course toEntity(CourseModel cto) {

		Course entity = new Course();

		entity.setCourse_name(cto.getCourse_name().toLowerCase());

		/*
		 * entity.setTrainer_id(cto.getTrainer_id());
		 * 
		 * entity.setComment(cto.getComment());
		 */

		return entity;

	}
	public void deleteCourse(int id)
	{
		repository.deleteById(id);
	}



}
