package com.DemandDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DemandDetails.Model.Employee;
import com.DemandDetails.Model.HiringDemand;
import com.DemandDetails.Model.Location;
import com.DemandDetails.Service.HiringService;
@RestController

@CrossOrigin(origins="*", allowedHeaders = "*")
public class HiringController {

	@Autowired
	HiringService hiringService;

	@RequestMapping(value = "/hel", method = RequestMethod.GET)
	public String tester() {
		return "testing complete";

	}

	@RequestMapping(value = "/api/hiringDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<HiringDemand> getAllHiringDetails() {
		return hiringService.getAllDemandDetails();
	}

	@RequestMapping(value = "/api/hiringDetails", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public HiringDemand addHiringDetails(@RequestBody HiringDemand hd) {
		return hiringService.addHiringDetails(hd);
	}

	@RequestMapping(value = "/api/hiringDetails/{id}", method = RequestMethod.PATCH, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public HiringDemand updateHiringDetail(@PathVariable(value = "id") int id, @RequestBody HiringDemand hd) {
		return hiringService.updateHiringDetail(id, hd);
	}

	@RequestMapping(value = "/api/employees", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return hiringService.getAllEmployees();
	}

	@RequestMapping(value = "/api/locations", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Location> getAllLocations() {
		return hiringService.getAllLocations();
	}
}