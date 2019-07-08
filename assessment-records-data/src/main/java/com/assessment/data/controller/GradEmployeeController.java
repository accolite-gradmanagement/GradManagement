package com.assessment.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.data.entity.GradEmployee;
import com.assessment.data.service.GradEmployeeService;


@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class GradEmployeeController {
	
	@Autowired
	private GradEmployeeService gradEmployeeService;
	
	@RequestMapping("/employees")
	public @ResponseBody ResponseEntity<List<GradEmployee>> getAllEmployees(){
		
		List<GradEmployee> gradEmployees = gradEmployeeService.getAllEmployees();
		if(gradEmployees.isEmpty()) {
			System.out.println("Grad Employees empty");
			return new ResponseEntity<List<GradEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<GradEmployee>>(gradEmployees,HttpStatus.OK);
	}
	
	
	@RequestMapping("/employee/{employeeId}")
	public  @ResponseBody ResponseEntity<GradEmployee> getEmployee(@PathVariable int employeeId) {
		GradEmployee gradEmployee = gradEmployeeService.getGradEmployee(employeeId);
		if(gradEmployee == null) {
			System.out.println("Grad Employee with id "+employeeId +"not found");
			return new ResponseEntity<GradEmployee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<GradEmployee>(gradEmployee, HttpStatus.OK);	
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value= "/employees" )
	public ResponseEntity<Void> addGradEmployee(@RequestBody GradEmployee gradEmployee) {
		if(gradEmployee == null) {
			System.out.println("Grad employee null");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		if(gradEmployeeService.getGradEmployee(gradEmployee.getEmployeeId()) != null) {
			System.out.println("Grad Employee(id) already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		gradEmployeeService.addGradEmployee(gradEmployee);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value= "/employees" )
	public ResponseEntity<GradEmployee> updateGradEmployee(@RequestBody GradEmployee gradEmployee) {
		if(gradEmployee == null) {
			System.out.println("Grad Employee null");
			return new ResponseEntity<GradEmployee>(HttpStatus.NOT_FOUND);
		}
		gradEmployeeService.updateGradEmployee(gradEmployee);
		return new ResponseEntity<GradEmployee>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/employees/{employeeId}" )
	public ResponseEntity<GradEmployee> deleteGradEmployee(@PathVariable int employeeId ) {
		GradEmployee gradEmployee  = gradEmployeeService.getGradEmployee(employeeId);
		if(gradEmployee == null) {
			System.out.println("Unable to delete. Employee with employee id " + employeeId + " not found");
			return new ResponseEntity<GradEmployee>(HttpStatus.NOT_FOUND);
		}
		gradEmployeeService.deleteGradEmployee(employeeId);
		return new ResponseEntity<GradEmployee>(HttpStatus.NO_CONTENT);
	}


	

}
