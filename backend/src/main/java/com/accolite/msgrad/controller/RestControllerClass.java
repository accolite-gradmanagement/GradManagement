package com.accolite.msgrad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.msgrad.dao.UserDao;
import com.accolite.msgrad.model.User;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class RestControllerClass 
{
	@Autowired
	User customUser;
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public List<User> getUsers()
	{
		return userdao.viewUser();
	}
	@RequestMapping("test")
	public String getString( ) {
		return "xcvdxv";
	}
	@RequestMapping(value="putUser",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void putUser(@RequestBody User user)
	{
		userdao.saveUser(user);
	}
	
	@RequestMapping(value="putLoginUser",method = RequestMethod.POST)
	public void putloginUser(@RequestBody ObjectNode obj)
	{
		
	}

}
