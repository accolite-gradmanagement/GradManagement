package com.accolite.grads.exception;

public class GradNotFoundException extends RuntimeException {
	public GradNotFoundException(Long id) {
		System.out.println("Cannot find Grad with id: " + id);
	}
}
