package com.youtubehp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtubehp.Student;

@RestController
public class MyController {
	
	@Autowired 
	@Qualifier("student 1")
	private Student student;
	
	
	@RequestMapping(value ="/bhanu", method = RequestMethod.POST)
	public Student home(@RequestBody Student st) {
		
		System.out.println("this is home method");
		st.studying();
		this.student.setName("Bhanu Pradeep Kumar");
		return this.student;
	}
	
	@RequestMapping(value="/bhanu/{userId}",method =RequestMethod.GET)
	public String user(@PathVariable("userId") Integer userId) {
		return String.valueOf(userId);
	}

}
//@ResponseBody replacing this with rest controller annotation 
//@Controller
//public class MyController {
//	
//	
//	@RequestMapping(value="/bhanu",method= RequestMethod.GET)
//	@ResponseBody
//	public String home() {
//		System.out.println("this is home method");
//		return "welcome to gorre home";
//	}
//	
//}
