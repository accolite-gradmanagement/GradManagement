package com.accolite.msgrad.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.accolite.msgrad.dto.PasswordRecoveryDto;
import com.accolite.msgrad.model.Login;
import com.accolite.msgrad.model.User;
import com.accolite.msgrad.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	public PasswordRecoveryDto passwordrecovery;
	
	JdbcTemplate jTemplate;
	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}
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
            otp+= 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        System.out.println("otp is : " + otp);
        return otp; 
    } 

	@Override
	public int passwordRecovery(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi " + to + "\n\n otp is "+ passwordrecovery.getOtp() );
		int length = 4;
		passwordrecovery.setSubject(subject);
		passwordrecovery.setText(text);
		passwordrecovery.setToMail(to);
		
		String sql = "SELECT EMAIL_ID FROM USERS WHERE EMAIL_ID='"+passwordrecovery.getToMail()+"';";
//		this.jTemplate.execute(sql);
		List<User> temp = jTemplate.query(sql, new RowMapper<User>(){
			
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setEmailId(rs.getString("EMAIL_ID"));
				return m;
			}
		});
		if(temp.isEmpty()) {
			System.out.println("isempty");
			return 0;
		}
		sql = "SELECT TOMAIL FROM OTPVALIDATION WHERE TOMAIL='"+passwordrecovery.getToMail()+"';";
		List<PasswordRecoveryDto> temp2 = jTemplate.query(sql, new RowMapper<PasswordRecoveryDto>(){
			
			public PasswordRecoveryDto mapRow(ResultSet rs, int arg1) throws SQLException {
				PasswordRecoveryDto m = new PasswordRecoveryDto();
				m.setToMail(rs.getString("TOMAIL"));
				return m;
			}
		});
		if(!temp2.isEmpty()) {
			passwordrecovery.setOtp(OTP(length));
			sql ="UPDATE OTPVALIDATION SET OTP = "+"'"+passwordrecovery.getOtp() +"'"+" WHERE TOMAIL = "+"'"+passwordrecovery.getToMail()+"'"+";"; 
			System.out.println(sql);
			passwordrecovery.setOtp(OTP(length));

			emailSender.send(message);
			
			this.jTemplate.execute(sql);
			return 1;
		}		
		passwordrecovery.setOtp(OTP(length));
		sql = "INSERT INTO OTPVALIDATION(TOMAIL,SUBJECT, TEXT, OTP)"+" VALUES('"+passwordrecovery.getToMail()+"','"+passwordrecovery.getSubject()+"','" + passwordrecovery.getText()+"','"+passwordrecovery.getOtp()+ "')";	
		System.out.println(sql);
		this.jTemplate.execute(sql);
		message.setText("Hi " + to + "\n\n otp is "+ passwordrecovery.getOtp() );
		emailSender.send(message);
		return 1;
	}
	
}