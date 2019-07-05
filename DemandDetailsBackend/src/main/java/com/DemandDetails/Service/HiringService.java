package com.DemandDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DemandDetails.Dao.HiringDao;
import com.DemandDetails.Model.Employee;
import com.DemandDetails.Model.HiringDemand;
import com.DemandDetails.Model.Location;

@Service
public class HiringService {

	@Autowired
	HiringDao hiringDao;
	
	public List<HiringDemand> getAllDemandDetails() {
		return hiringDao.getAllDemandDetails();
	}

	public HiringDemand addHiringDetails(HiringDemand hd) {
		return hiringDao.addHiringDetails(hd);
	}
	
	public List<Employee> getAllEmployees() {
		return hiringDao.getAllEmployees();
	}
	
	public List<Location> getAllLocations() {
		return hiringDao.getAllLocations();
	}
	public Employee addEmployee(Employee employee) {
		return this.hiringDao.addEmployee(employee);
	}

}
