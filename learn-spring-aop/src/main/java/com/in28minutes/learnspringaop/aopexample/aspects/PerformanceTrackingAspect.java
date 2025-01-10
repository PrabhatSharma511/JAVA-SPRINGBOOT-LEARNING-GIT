package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Around("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
	@Around("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.TrackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		//Start timer
		long startTimeMillis = System.currentTimeMillis();
		
		//execute code
		Object returnedValue = proceedingJoinPoint.proceed();
		//stop timer
		long endTimeMillis = System.currentTimeMillis();
		long executionTime = endTimeMillis-startTimeMillis;
		
		logger.info("Around aspect {}, 	Method executed in {} ",proceedingJoinPoint,executionTime);
		
		return returnedValue;
		
	}
	
}
