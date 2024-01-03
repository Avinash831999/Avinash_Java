package com.example.parallelapicall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import com.example.parallelapicall.service.AsyncTaskService;

@SpringBootApplication
@EnableAsync
public class ParallelApiCallApplication{// implements CommandLineRunner{
	// private static final Logger logger = LoggerFactory.getLogger(ParallelApiCallApplication.class);
	 
	 @Autowired
	 AsyncTaskService asyncTaskService;
	public static void main(String[] args) {
		SpringApplication.run(ParallelApiCallApplication.class, args);
	}
	
	
//		@Override
//		public void run(String... args) throws Exception {
//			 long start = System.currentTimeMillis();
//			 CompletableFuture < String > page1 = asyncTaskService.asyncCall1();
//		        CompletableFuture < String > page2 = asyncTaskService.asyncCall1();
//		        CompletableFuture < String > page3 = asyncTaskService.asyncCall1();
//		        CompletableFuture < String > page4 = asyncTaskService.asyncCall1();
//		        // Wait until they are all done
//		        CompletableFuture.allOf(page1, page2, page3, page4).join();
//
//		        // Print results, including elapsed time
//		        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
//		        logger.info("--> " + page1.get());
//		        logger.info("--> " + page2.get());
//		        logger.info("--> " + page3.get());
//		        logger.info("--> " + page4.get());
//		}

}
