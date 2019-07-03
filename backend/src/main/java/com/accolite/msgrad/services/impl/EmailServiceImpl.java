package com.accolite.msgrad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.accolite.msgrad.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;



	@Override
	public void passwordRecovery(String to, String subject, String text, String link) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n" + text + "\n\n\nVisit " + link);
		System.out.println("hello i am mmmm");
		emailSender.send(message);
	}

	
}