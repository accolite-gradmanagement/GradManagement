package com.accolite.msgrad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.msgrad.dao.UserDao;
import com.accolite.msgrad.model.Employee;
import com.accolite.msgrad.model.Login;
import com.accolite.msgrad.model.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.accolite.msgrad.dto.PasswordRecoveryDto;
import com.accolite.msgrad.services.interfaces.EmailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestControllerClass 
{
	@Autowired
	User customUser;
	@Autowired
	UserDao userdao;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public List<User> getUsers()
	{
		return userdao.viewUser();
	}
	
	@RequestMapping(value="putUser",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public long putUser(@RequestBody User user)
	{
		return userdao.saveUser(user);
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User putloginUser(@RequestBody Login login)
	{
		System.out.println(login.getUsername()+" "+login.getPass_word());
		return userdao.loginUser(login);
	}
	
	@RequestMapping(value="addEmployee",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public long putUser(@RequestBody Employee employee)
	{
		return userdao.addEmployee(employee);
	}

	@RequestMapping(value="update",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateUser(@RequestBody User user)
	{
		return userdao.updateUser(user);
	}
	
	@RequestMapping(value="passwordrecovery",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void passwordRecovery(@RequestBody PasswordRecoveryDto passwordRecovery) {
		System.out.println(passwordRecovery);
		emailService.passwordRecovery(passwordRecovery.getToMail(), passwordRecovery.getSubject(),
				passwordRecovery.getText());
	}

}
