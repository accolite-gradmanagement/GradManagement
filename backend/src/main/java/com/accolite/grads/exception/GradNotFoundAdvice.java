package com.accolite.grads.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GradNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(GradNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String gradNotFoundHandler(GradNotFoundException e) {
		return e.getMessage();
	}
}
