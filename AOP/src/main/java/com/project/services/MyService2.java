package com.project.services;

import org.springframework.stereotype.Service;

@Service
public class MyService2 {
	public String studentClass()  {
		System.out.println("In service2");
		
		return "ECE A";
	}
}
