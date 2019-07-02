package com.assessment.data.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.model.GradEmployee;

public interface GradEmployeeRepository extends PagingAndSortingRepository<GradEmployee, Integer>{

	List<GradEmployee> findByEmployeeIdIn(List<Integer> employeeIds);
	
	List<GradEmployee> findByBatchNameAndYear(String batchName, int year);

	List<GradEmployee> findByYear(int year);
}
