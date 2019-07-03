package com.accolite.msgrad.services.interfaces;

/**
 * Email Related operations can be performed using EmailService
 *
 */
public interface EmailService {

	/**
	 * sends a password recovery mail
	 * 
	 * @param to      receiver email address
	 * @param subject subject of mail
	 * @param text    body of mail
	 * @param link    url to be included
	 */
	public void passwordRecovery(String to, String subject, String text, String link);

	
}
