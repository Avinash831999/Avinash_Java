package com.example.demoapp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.util.AnnotatedTypeScanner;

import com.example.demoapp.testpackage.MyClass;

@Configuration
public class MyConfig implements ApplicationListener<ContextRefreshedEvent>{

	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Set<String> pkgSet = new HashSet<>();
		pkgSet.add("com.example.demoapp.testpackage");
		AnnotatedTypeScanner scanner = new AnnotatedTypeScanner(LoadOnStartup.class);
		Set<Class<?>> classes = scanner.findTypes(pkgSet);
		
		
		
		classes.forEach(classRef ->{
			try {
				Class.forName(classRef.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		
	}

}
