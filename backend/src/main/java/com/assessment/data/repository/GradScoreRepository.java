package com.assessment.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.entity.GradEmployee;
import com.assessment.data.entity.GradScore;
import com.assessment.data.model.GradScoreCompositeKey;
import com.assessment.data.entity.GradTest;

public interface GradScoreRepository extends PagingAndSortingRepository<GradScore, GradScoreCompositeKey>{

	List<GradScore> findByGradEmployeeInAndGradTestOrderByScoreDesc(List<GradEmployee> gradEmployees, GradTest gradTest);

	List<GradScore> findByGradEmployee(GradEmployee gradEmployee);

	List<GradScore> findByGradEmployeeIn(List<GradEmployee> gradEmployees);

    GradScore findByGradEmployeeAndGradTest(GradEmployee gradEmployee, GradTest gradTest);

    @Query(value = "with grad_rank(employee_id,test_id,grad) as (select employee_id,test_id,dense_rank() over(order by score desc) as grad " +
			" from grad_score where test_id = ?2 ) " +
			" select grad " +
			" from grad_rank " +
			" where employee_id = ?1 and test_id = ?2 ",nativeQuery = true)
	public  int calculateRank(int employeeId, int testId);




}
