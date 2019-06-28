package com.assessment.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.data.model.GradEmployee;
import com.assessment.data.model.GradScore;
import com.assessment.data.model.GradTest;
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
	public ResponseEntity<List<GradScore>> getEmployeesByYearAndBatchAndTestName(@PathVariable("year") int year, @PathVariable("batchName") String batchName, @PathVariable("testName") String testName){
		
		List<GradEmployee> gradEmployees = gradEmployeeService.findByBatchNameAndYear(batchName, year);
		GradTest gradTest = gradTestService.findByTestName(testName);
		List<GradScore> gradScores = gradScoreService.findByGradEmployeeInAndGradTest(gradEmployees, gradTest);
		if(gradScores == null) {
			System.out.println("Grad Score empty*********************************");
//			return new ResponseEntity<List<WrapperGradEmployeeScore>>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<List<GradScore>>(HttpStatus.NOT_FOUND);
		}
//		List<WrapperGradEmployeeScore> wrapperGradEmployeeScores = new ArrayList<WrapperGradEmployeeScore>();
//		WrapperGradEmployeeScore wrapperGradEmployeeScore;
//		for (GradScore gradScore : gradScores) {
//			System.out.println(gradScore.getScore()+"*******************************************************");
//			wrapperGradEmployeeScore = new  WrapperGradEmployeeScore(gradScore);//, gradScore.getGradEmployee().getEmployeeName(), gradTest);
//			wrapperGradEmployeeScores.add(wrapperGradEmployeeScore);
//		}
		
//		return new ResponseEntity<List<WrapperGradEmployeeScore>>(wrapperGradEmployeeScores, HttpStatus.OK);	
		
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
//	
	
}
