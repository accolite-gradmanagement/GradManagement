package com.accolite.msgrad.dto;


public class PasswordRecoveryDto {

	@Override
	public String toString() {
		return "PasswordRecoveryDto [toMail=" + toMail + ", subject=" + subject + ", text=" + text + ", link=" + link
				+ "]";
	}

	private String toMail;
	private String subject;
	private String text;
	private String link;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
