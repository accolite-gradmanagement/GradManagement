package com.assessment.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.data.model.GradEmployee;
import com.assessment.data.model.GradScore;
import com.assessment.data.model.GradTest;
import com.assessment.data.repository.GradScoreRepository;

@Service
public class GradScoreService {

	@Autowired
	private GradScoreRepository gradScoreRepository;
	
	public List<GradScore> findByGradEmployeeInAndGradTest(List<GradEmployee> gradEmployees, GradTest gradTest){
		return gradScoreRepository.findByGradEmployeeInAndGradTest(gradEmployees,gradTest);
	}

	public List<GradScore> findByGradEmployee(GradEmployee gradEmployee){
		return gradScoreRepository.findByGradEmployee(gradEmployee);
	}

}
