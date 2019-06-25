package com.DemandDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DemandDetails.Service.HiringService;

@RestController
public class HiringController {

	@Autowired
	HiringService hiringService;

	@RequestMapping(value = "/hel", method = RequestMethod.GET)
	public String tester() {
		return "testing complete";

	}
}