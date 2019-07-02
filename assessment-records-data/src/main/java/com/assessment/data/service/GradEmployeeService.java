package com.assessment.data.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.data.model.GradEmployee;
import com.assessment.data.repository.GradEmployeeRepository;

@Service
public class GradEmployeeService {
	
	@Autowired
	private GradEmployeeRepository gradEmployeeRepository;
	
	public List<GradEmployee> getAllEmployees(){
		List<GradEmployee> gradEmployees = new ArrayList<>();
		gradEmployeeRepository.findAll().forEach(gradEmployees::add);
		return gradEmployees;
	}
	
	public GradEmployee getGradEmployee(int employeeId) {
		return gradEmployeeRepository.findById(employeeId).isPresent()?gradEmployeeRepository.findById(employeeId).get():null; 
	}
	
	
	public void addGradEmployee(GradEmployee gradEmployee) {
		gradEmployeeRepository.save(gradEmployee);
	}
	
	public void updateGradEmployee(GradEmployee gradEmployee) {
		gradEmployeeRepository.save(gradEmployee);
	}

	public void deleteGradEmployee(int employeeId) {
		
		GradEmployee employeeDelete = gradEmployeeRepository.findById(employeeId).isPresent()?gradEmployeeRepository.findById(employeeId).get():null ;
		gradEmployeeRepository.delete(employeeDelete);
		
	}
	
	public List<GradEmployee> findByEmployeeIdIn(List<Integer> employeeIds){
		return gradEmployeeRepository.findByEmployeeIdIn(employeeIds);
	}
	
	public List<GradEmployee> findByBatchNameAndYear(String batchName, int year){
		return gradEmployeeRepository.findByBatchNameAndYear(batchName, year);
	}

	public List<GradEmployee> findByYear(int year){
		return gradEmployeeRepository.findByYear( year);
	}

}
