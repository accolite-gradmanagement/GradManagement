package com.accolite.msgrad.dao;

import java.util.List;

import com.accolite.msgrad.model.Login;
import com.accolite.msgrad.model.User;



public interface InfUser 
{
	long saveUser(User user);
	User loginUser(Login login);
	List<User> viewUser();

}
