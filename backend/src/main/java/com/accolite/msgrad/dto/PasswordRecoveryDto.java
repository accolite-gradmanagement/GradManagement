package com.accolite.msgrad.dto;


public class PasswordRecoveryDto {

	private String toMail;
	private String subject;
	private String text;
	static private String otp;

	@Override
	public String toString() {
		return "PasswordRecoveryDto [toMail=" + toMail + ", subject=" + subject + ", text=" + text + ", otp=" + otp
				+ "]";
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	
}
