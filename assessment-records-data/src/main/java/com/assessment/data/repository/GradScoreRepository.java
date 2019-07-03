package com.assessment.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.model.GradEmployee;
import com.assessment.data.model.GradScore;
import com.assessment.data.model.GradScoreCompositeKey;
import com.assessment.data.model.GradTest;

public interface GradScoreRepository extends PagingAndSortingRepository<GradScore, GradScoreCompositeKey>{

	List<GradScore> findByGradEmployeeInAndGradTestOrderByScoreDesc(List<GradEmployee> gradEmployees, GradTest gradTest);

	List<GradScore> findByGradEmployee(GradEmployee gradEmployee);
	
}
