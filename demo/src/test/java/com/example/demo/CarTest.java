package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class CarTest {
	
	@Autowired
	Car mycar;
	CarObj mycarObj;
	
	public CarTest() {
		System.out.println("car  test started check ...");

	}
	@Test
	void carStarts() {
		mycar.drive();
		mycarObj.driveObj();
	}
	

}
