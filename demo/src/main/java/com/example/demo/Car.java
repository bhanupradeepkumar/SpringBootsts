package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class Car {

	public Car() {
		System.out.println("car started check ...");
		
	}
	
	public void drive() {
		System.out.println("tighten seat bealts iam driving....");
	}
	
}
