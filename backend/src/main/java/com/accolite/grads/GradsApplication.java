package com.accolite.grads;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accolite.grads.model.Grad;
import com.accolite.grads.repository.GradRepository;

@SpringBootApplication
public class GradsApplication{

	@Autowired
	private GradRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(GradsApplication.class, args);
	}
	
//	@Override
//    public void run(String... args) {
//		Grad grad1 = new Grad(
//				"2546",
//				"Royston Dmello",
//				"dm1@gmail",
//				"SPIT",
//				"Mumbai",
//				"N",
//				"BE",
//				"COMPS",
//				(float) 9.0,
//				1234567890,
//				"de@gmail.com",
//				new Date(),
//				"Mumbai",
//				"http://google.com"
//				);
//		Grad grad2 = new Grad(
//				"2547",
//				"Reysten Dellom",
//				"dm2@gmail",
//				"SPITE",
//				"Mumbaiee",
//				"N",
//				"BTech",
//				"COMPS",
//				(float) 9.0,
//				1234567891,
//				"dem@gmail.com",
//				new Date(),
//				"Mumbai",
//				"http://google.com"
//				);
//		repository.save(grad1);
//		repository.save(grad2);
//		System.out.println("Entered successfully");
//    }
}
