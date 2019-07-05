package com.assessment.data.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.assessment.data.model.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assessment.data.service.GradEmployeeService;
import com.assessment.data.service.GradScoreService;
import com.assessment.data.service.GradTestService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class GradScoreController {

	@Autowired
	private GradScoreService gradScoreService;
	
	@Autowired
	private GradTestService gradTestService;
	
	@Autowired
	private GradEmployeeService gradEmployeeService;
	
	@GetMapping(value="/scores/{year}/{batchName}/{testName}")
	public ResponseEntity<List<GradScore>> getEmployeesScoreByYearAndBatchAndTestName(@PathVariable("year") int year, @PathVariable("batchName") String batchName, @PathVariable("testName") String testName){
		
		List<GradEmployee> gradEmployees = gradEmployeeService.findByBatchNameAndYear(batchName, year);
		GradTest gradTest = gradTestService.findByTestNameAndBatchName(testName,batchName);
		List<GradScore> gradScores = gradScoreService.findByGradEmployeeInAndGradTestByOrderByScoreDesc(gradEmployees, gradTest);
		if(gradScores == null) {
			System.out.println("Grad Score empty*********************************");
			return new ResponseEntity<List<GradScore>>(HttpStatus.NOT_FOUND);
		}

		if(gradScores.isEmpty()){
			return new ResponseEntity<List<GradScore>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<GradScore>> (gradScores,HttpStatus.OK);
	}
	
//	@RequestMapping(value="/scores/year/batchName/testName",method=RequestMethod.GET)
//	public ResponseEntity<List<Year>> getYearAndBatchAndTest(){
//		List<Year> years = new ArrayList<Year>();
//		List<Batch> batches = new ArrayList<Batch>();
//		List<String> testNames = new ArrayList<String>();
//
//		return new ResponseEntity<List<Year>> (years,HttpStatus.OK);
//	}



	@RequestMapping(value="/scores/year",method=RequestMethod.GET)
	public ResponseEntity<List<Integer>> getYears(){
		Set<Integer> yearSet = new HashSet<>();
		List<GradEmployee> gradEmployees = gradEmployeeService.getAllEmployees();
		for(GradEmployee ge: gradEmployees){
			yearSet.add(ge.getYear());
		}
		List<Integer> years = new ArrayList<>();
		years.addAll(yearSet);
		if(years.isEmpty()){
			return  new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);
		}
		return  new ResponseEntity<List<Integer>>(years,HttpStatus.OK);
	}

	@RequestMapping(value="/scores/{year}/batch",method=RequestMethod.GET)
	public ResponseEntity<List<String>> getBatchOfYear(@PathVariable int year){
		List<String> batches = new ArrayList<>();
		List<GradEmployee> gradEmployees = gradEmployeeService.findByYear(year);
		Set<String> batchSet = new HashSet<>();
		for(GradEmployee ge: gradEmployees){
			batchSet.add(ge.getBatchName());
		}
		batches.addAll(batchSet);
		if (batches.isEmpty()){
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(batches,HttpStatus.OK);
	}

	@RequestMapping(value="/scores/{batch}/test",method=RequestMethod.GET)
	public ResponseEntity<List<GradTest>> getTest(@PathVariable String batch){
		List<GradTest> gradTests = gradTestService.findByBatchName(batch);
		if(gradTests == null){
			return new ResponseEntity<List<GradTest>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<GradTest>>(gradTests,HttpStatus.OK);
	}


	@RequestMapping(value="/scores/{batch}/testname",method=RequestMethod.GET)
	public ResponseEntity<List<String>> getTestName(@PathVariable String batch){
		List<String> testnames = new ArrayList<>();
		List<GradTest> gradTests = gradTestService.findByBatchName(batch);
		Set<String> testNameSet = new HashSet<>();
		for(GradTest gt: gradTests){
			testNameSet.add(gt.getTestName());
		}
		testnames.addAll(testNameSet);
		if (testnames.isEmpty()){
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<String>>(testnames,HttpStatus.OK);
	}


	@RequestMapping(value="/scores/{employeeId}",method=RequestMethod.GET)
	public ResponseEntity<List<GradScore>> getEmployeesScoreByYearAndBatchAndTestName(@PathVariable int employeeId) {
		GradEmployee gradEmployee = gradEmployeeService.getGradEmployee(employeeId);
		List<GradScore>  gradScores = gradScoreService.findByGradEmployee(gradEmployee);
		if(gradScores == null){
			return new ResponseEntity<List<GradScore>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<GradScore>>(gradScores,HttpStatus.OK);
	}

	@RequestMapping(value="/scores/name/{employeeName}",method=RequestMethod.GET)
	public ResponseEntity<List<GradScore>> findEmployeesScoreFromEmployeeName(@PathVariable String employeeName) {
		List<GradEmployee> gradEmployees = gradEmployeeService.findByEmployeeNameLikeIgnoreCase("%"+employeeName+"%");
		List<GradScore>  gradScores = gradScoreService.findByGradEmployeeIn(gradEmployees);
		if(gradScores == null){
			return new ResponseEntity<List<GradScore>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<GradScore>>(gradScores,HttpStatus.OK);
	}


	@RequestMapping(value = "/add/score",method = RequestMethod.POST)
	public ResponseEntity<Void> addScoreDetails(@RequestBody String json){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ScoreDetails scoreDetails = objectMapper.readValue(json, ScoreDetails.class);

			GradScore gradScore = new GradScore();

			GradEmployee gradEmployee = gradEmployeeService.getGradEmployee(scoreDetails.getEmployeeId());
			if(gradEmployee == null){
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
//			gradScore.getGradEmployees().add(gradEmployee);
			gradScore.setGradEmployee(gradEmployee);



			GradTest gradTest = gradTestService.findByTestName(scoreDetails.getTestName());
			if(gradTest ==  null){
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
//			gradScore.getGradTest().add(gradTest);
			gradScore.setGradTest(gradTest);

			gradScore.setScore(scoreDetails.getScore());
			gradScore.setCorrectQuestions(scoreDetails.getCorrectQuestions());
			gradScore.setIncorrectQuestions(scoreDetails.getIncorrectQuestions());
			gradScore.setSuccessPercentage(scoreDetails.getSuccessPercentage());
			gradScore.setRank(scoreDetails.getRank());

			gradScoreService.addGradScore(gradScore);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch (JsonParseException e) {
			e.printStackTrace();
		}
		catch (JsonMappingException e) {
			e.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}


}
