package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.services.MyService;
import com.project.services.MyService2;

@RestController
public class MyController {
	
	@Autowired
	MyService service;
	
	@Autowired
	MyService2 service2;
	
	@GetMapping("/studentClass")
	public String studentClass() {
		String sr = service2.studentClass();
		return sr;
	}
	
	@GetMapping("/getname")
	public String getStudentName() {
		String str = "No Name";
		try {
			str= service.student(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		finally {
			return str;
		}
	}
}
