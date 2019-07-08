package com.project.courses.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.courses.demo.entity.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer,Integer> {
	public Trainer findByTrainerName(String trainerName);
	public Trainer findByTrainerId(Integer trainerId);

}
