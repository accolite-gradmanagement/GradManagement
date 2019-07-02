package com.assessment.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.model.GradTest;

import java.util.List;

public interface GradTestRepository extends PagingAndSortingRepository<GradTest, Integer> {

	GradTest findByTestName(String testName);

	List<GradTest> findByBatchName(String batchName);

}
