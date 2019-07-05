package com.DemandDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DemandDetails.Model.Employee;
import com.DemandDetails.Model.HiringDemand;
import com.DemandDetails.Model.Location;
import com.DemandDetails.Service.HiringService;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HiringController {

	@Autowired
	HiringService hiringService;

	@GetMapping(value = "/hel")
	public String tester() {
		return "testing complete";
	}

	@GetMapping(value = "/api/hiringDetails", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<HiringDemand> getAllHiringDetails() {
		return hiringService.getAllDemandDetails();
	}

	@PostMapping(value = "/api/hiringDetails", consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public HiringDemand addHiringDetails(@RequestBody HiringDemand hd) {
		return hiringService.addHiringDetails(hd);
	}

	@GetMapping(value = "/api/employees", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return hiringService.getAllEmployees();
	}

	@GetMapping(value = "/api/locations", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Location> getAllLocations() {
		return hiringService.getAllLocations();
	}
	@PostMapping(value="/api/employee", consumes="application/json") 
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.hiringService.addEmployee(employee);
	}
}