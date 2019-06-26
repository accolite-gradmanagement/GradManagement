package com.DemandDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DemandDetails.Dao.HiringDao;
import com.DemandDetails.Model.Employee;
import com.DemandDetails.Model.HiringDemand;

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
	
	public HiringDemand updateHiringDetail(int id, HiringDemand hd) {
		return hiringDao.updateHiringDetail(id, hd);
	}
	
	public List<Employee> getAllEmployees() {
		return hiringDao.getAllEmployees();
	}
}
