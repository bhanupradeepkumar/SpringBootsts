package com.youtubehp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mypack.Dog;


@SpringBootApplication

public class DurgeshApplication implements CommandLineRunner{
	@Autowired
	@Qualifier("student 1")
	private Student student;
	@Autowired
	private Date date;
	@Autowired
	private	 Emp emp;
	@Autowired
	private Dog harley;
	public static void main(String[] args) {
		SpringApplication.run(DurgeshApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.student.studying();
		date.timeTeller();
		this.emp.whatsYourName();
		this.harley.Barking();
	}

}
