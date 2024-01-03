package com.project.services;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	 
	public String student(int a) throws Exception {
		System.out.println("In service");
		if(a==0)
		throw new Exception("Exception thrown");
		else 
		return "Avinash";
	}
}
