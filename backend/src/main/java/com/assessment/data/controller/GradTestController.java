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

import com.assessment.data.model.GradTest;
import com.assessment.data.service.GradTestService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class  GradTestController {
	
	@Autowired
	private GradTestService gradTestService;

	@RequestMapping("/gradTests")
	public ResponseEntity<List<GradTest>> getTests(){
		List<GradTest> gradTests = gradTestService.getAllTests();
		if(gradTests.isEmpty()) {
			System.out.println("Grad Tests empty");
			return new ResponseEntity<List<GradTest>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<GradTest>>(gradTests,HttpStatus.OK);
	}
	
	@RequestMapping("/gradTests/{gradTestId}")
	public  @ResponseBody ResponseEntity<GradTest> getGradTest(@PathVariable int gradTestId) {
		GradTest gradTest =gradTestService.getGradTest(gradTestId);
		if(gradTest == null) {
			System.out.println("Grad Test with id "+gradTestId +"not found");
			return new ResponseEntity<GradTest>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<GradTest>(gradTest, HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/gradTests" )
	public ResponseEntity<Void> addGradTest(@RequestBody GradTest gradTest) {
		if(gradTest == null) {
			System.out.println("Grad test null");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		if(gradTestService.getGradTest(gradTest.getTestId()) != null) {
			System.out.println("Grad Test(id) already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		gradTestService.addGradTest(gradTest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/gradTests" )
	public ResponseEntity<GradTest> updateGradTest(@RequestBody GradTest gradTest) {
		if(gradTest == null) {
			System.out.println("Grad Test null");
			return new ResponseEntity<GradTest>(HttpStatus.NOT_FOUND);
		}
		gradTestService.updateGradTest(gradTest);
		return new ResponseEntity<GradTest>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/gradTests/{gradTestId}" )
	public ResponseEntity<GradTest>deleteGradTest(@PathVariable int gradTestId ) {
		GradTest gradTest  = gradTestService.getGradTest(gradTestId);
		if(gradTest == null) {
			System.out.println("Unable to delete. GradTest with id " + gradTestId + " not found");
			return new ResponseEntity<GradTest>(HttpStatus.NOT_FOUND);
		}
		gradTestService.deleteGradTest(gradTestId);
		return new ResponseEntity<GradTest>(HttpStatus.NO_CONTENT);
	}
}
