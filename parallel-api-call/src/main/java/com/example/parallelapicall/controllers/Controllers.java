package com.example.parallelapicall.controllers;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parallelapicall.service.AsyncTaskService;

@RestController
public class Controllers {
	
	
	
	@GetMapping("/getname")
	public String getName() throws InterruptedException {
		Thread.sleep(5000);
		return Thread.currentThread().getName()+" Avinash " + new Date().toString();
	}
	
	@GetMapping("/getname2")
	public String getName2() throws InterruptedException {
		return  Thread.currentThread().getName()+" Avinash2 " + new Date().toString();
	}
	
	@Autowired
    private AsyncTaskService asyncTaskService;
    
	@GetMapping("/example")//concurrent call for same api
	public String handleExampleRequest1() throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> call1 = asyncTaskService.concurrentCall();
		return call1.get();
       
    }
	
	@GetMapping("/example2")
    public String handleExampleRequest() throws InterruptedException, ExecutionException {
		 
		CompletableFuture<String> call1 = asyncTaskService.asyncCall1();
		CompletableFuture<String> call2 = asyncTaskService.asyncCall2();
		 
		 CompletableFuture.allOf(call1, call2).join();
		
	return call1.get()+" "+call2.get();
    }
}
