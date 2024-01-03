package com.example.parallelapicall.service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService  {

	@Async
    public CompletableFuture<String> asyncCall1() throws InterruptedException {
        
        Thread.sleep(5000L);
        return CompletableFuture.completedFuture(Thread.currentThread().getName()+ " call 1 " + new Date().toString());
    }

    @Async
    public CompletableFuture<String> asyncCall2() throws InterruptedException {
    	Thread.sleep(3000L);
        return CompletableFuture.completedFuture(Thread.currentThread().getName()+ " call 2 " + new Date().toString());
    }
    
    
    @Async
    public CompletableFuture<String> concurrentCall() throws InterruptedException{
    	Thread.sleep(3000L);
        return CompletableFuture.completedFuture(Thread.currentThread().getName()+ " concurrentcall " + new Date().toString());
    }
}