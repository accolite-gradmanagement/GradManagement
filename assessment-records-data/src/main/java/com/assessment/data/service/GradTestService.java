package com.assessment.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.data.model.GradTest;
import com.assessment.data.repository.GradTestRepository;

@Service
public class GradTestService {
	
	@Autowired
	private GradTestRepository gradTestRepository;
	
	public List<GradTest> getAllTests(){
		List<GradTest> gradTests = new ArrayList<GradTest>();
		gradTestRepository.findAll().forEach(gradTests::add);
		return gradTests;
	}
	
	public GradTest getGradTest(int gradTestId) {
		return gradTestRepository.findById(gradTestId).isPresent()?gradTestRepository.findById(gradTestId).get():null;
	}
	
	public void addGradTest(GradTest gradTest) {
		gradTestRepository.save(gradTest);
	}
	
	public void updateGradTest(GradTest gradTest) {
		gradTestRepository.save(gradTest);
	}
	
	public void deleteGradTest(int gradTestId) {
		GradTest gradTestDelete = gradTestRepository.findById(gradTestId).isPresent()?gradTestRepository.findById(gradTestId).get():null;
		gradTestRepository.delete(gradTestDelete);
	}
	

	public GradTest findByTestName(String testName) {
		return gradTestRepository.findByTestName(testName);
	}
}
