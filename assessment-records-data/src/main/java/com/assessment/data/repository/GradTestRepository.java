package com.assessment.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.model.GradTest;

public interface GradTestRepository extends PagingAndSortingRepository<GradTest, Integer> {

	GradTest findByTestName(String testName);

}
