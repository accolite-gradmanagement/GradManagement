package com.assessment.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assessment.data.entity.GradTest;

import java.util.List;

public interface GradTestRepository extends PagingAndSortingRepository<GradTest, Integer> {

	GradTest findByTestNameAndBatchName(String testName,String batchName);

	List<GradTest> findByBatchName(String batchName);

    GradTest findByTestName(String testName);
}