package com.assessment.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.data.entity.GradEmployee;
import com.assessment.data.entity.GradScore;
import com.assessment.data.entity.GradTest;
import com.assessment.data.repository.GradScoreRepository;

@Service
public class GradScoreService {

	@Autowired
	private GradScoreRepository gradScoreRepository;
	
	public List<GradScore> findByGradEmployeeInAndGradTestByOrderByScoreDesc(List<GradEmployee> gradEmployees, GradTest gradTest){
		return this.calcRank(gradScoreRepository.findByGradEmployeeInAndGradTestOrderByScoreDesc(gradEmployees,gradTest));
	}

	public List<GradScore> findByGradEmployee(GradEmployee gradEmployee){
		return gradScoreRepository.findByGradEmployee(gradEmployee);
	}

	public List<GradScore> findByGradEmployeeIn(List<GradEmployee> gradEmployees) {
		return  gradScoreRepository.findByGradEmployeeIn(gradEmployees);
	}

	public void addGradScore(GradScore gradScore){
		gradScoreRepository.save(gradScore);
	}

    public GradScore findByGradEmployeeAndGradTest(GradEmployee gradEmployee, GradTest gradTest) {
    	return gradScoreRepository.findByGradEmployeeAndGradTest(gradEmployee,gradTest);
	}


	public int calculateRank(int employeeId, int testId){
		return gradScoreRepository.calculateRank(employeeId,testId);
	}

	public List<GradScore> calcRank(List<GradScore> gradScores){
		int rank =1 ;
		if(gradScores != null) {
			gradScores.get(0).setGradRank(rank);
			if(gradScores.size()>=2) {
				for (int i = 1; i < gradScores.size(); i++) {
					if (gradScores.get(i).getScore() == gradScores.get(i - 1).getScore()) {
						gradScores.get(i).setGradRank(rank);
					} else {
						gradScores.get(i).setGradRank(++rank);
					}
				}
			}
		}
		return gradScores;
	}
}
