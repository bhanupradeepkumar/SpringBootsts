package com.youtubehp;

public class Student {
	String name;
	Student(String name){
		this.name=name;
	}
	
	public Student() {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void studying() {
		System.out.println(this.name+" is  studying...");
	}

}
