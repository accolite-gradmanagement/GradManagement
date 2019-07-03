package com.accolite.msgrad.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.accolite.msgrad.dto.PasswordRecoveryDto;
import com.accolite.msgrad.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	public PasswordRecoveryDto passwordrecovery;
	
	public String OTP(int len) 
    { 
        System.out.println("Generating OTP using random() : "); 
  
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        String otp="";
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp+= 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        System.out.println("otp is : " + otp);
        return otp; 
    } 

	@Override
	public void passwordRecovery(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		int length = 4;
		passwordrecovery.setOtp(OTP(length));
		message.setText("Hi " + to + "\n\n otp is "+ passwordrecovery.getOtp() );
		emailSender.send(message);
	}
	
}