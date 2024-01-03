package com.example.demoapp.testpackage;

import com.example.demoapp.LoadOnStartup;

@LoadOnStartup
public class MyClass {

	static {
		System.out.println( "MyClass loaded *****************");
	}
	
}
