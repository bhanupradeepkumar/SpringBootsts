package com.youtubehp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {
	
	@Bean("student 1")
	@Lazy
	public Student getStudent() {
		System.out.println("creating first student object");
		return new Student("Student 1");
	}
	
	@Bean("student 2")
	@Lazy
	public Student createStudent() {
		System.out.println("creating second student object ");
		return new Student("Student 2");
	}
	
	@Bean
	public Date getDate() {
		System.out.println("creating new date");
		return new Date();
	}

}
