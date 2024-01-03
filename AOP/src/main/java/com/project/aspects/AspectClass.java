package com.project.aspects;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {
	
	@Before("execution(* com.project.services.MyService.*(..))")
	public void cla(JoinPoint jp) {
		System.out.println("Aspect before "+jp.getSignature().getName());
	}
	
	@After(  "execution(* com.project.services.MyService.*(..))")
	public void clas(JoinPoint jp) {
		System.out.println("Aspect after "+jp.getSignature().getName());
	}
	
	@AfterReturning(pointcut = "execution(* com.project.services.MyService.*(..))",returning = "result")
	public void classa(JoinPoint jp,Object result) {
		System.out.println("Aspect after returning "+jp.getSignature().getName()+ " "+result);
	}
	
	@AfterThrowing("execution(* com.project.services.MyService.*(..))")
	public void clasaaa(JoinPoint jp) {
		System.out.println("Aspect after throwing "+jp.getSignature().getName());
	}
	
	@Around("execution(* com.project.services.MyService2.*(..))")
	public Object clasaaaa(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Before in around "+jp.getSignature().getName() + "Arguments are ");
		
		
		Arrays.stream(jp.getArgs()).
			forEach(obj -> System.out.println(obj.toString()));
		
		System.out.println("Proceeding..");
		Object obj = jp.proceed();
		
		System.out.println("after in around ");
		return obj;
	}
	
}
