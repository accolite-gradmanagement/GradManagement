package com.accolite.msgrad.dao;

import java.util.List;

import com.accolite.msgrad.model.User;



public interface InfUser 
{
	Boolean  saveUser(User user);
	List<User> viewUser();

}
