package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	
	
	Logger logger = LoggerFactory.getLogger(getClass());

	//PointCut- when to do
	//execution(*PACKAGE.*.*(..))
	//we want to intercept executions(requests) going to all beans in this package
	//this logger works for every method execution in the package used in execution
	
	@Before("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
	public void beforelogMethodCall(JoinPoint joinPoint) {
		//Logic- what to do
		logger.info("Before Aspect - Method is called {}",joinPoint);
	}
	
	@After("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.allServicePackageConfigUsingBean()")
	public void afterlogMethodCall(JoinPoint joinPoint) {
		//Logic- what to do
		logger.info("After Aspect - Method is called {}",joinPoint);
	}
	
	@AfterThrowing(pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",throwing = "exception")
	public void afterThrowlogMethodCall(JoinPoint joinPoint,Exception exception) {
		//Logic- what to do
		logger.info("After Throwing Aspect - Method is called {}",joinPoint,exception);
	}
	
	
	@AfterReturning(pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",returning = "resultValue")
	public void afterReturnlogMethodCall(JoinPoint joinPoint,Object resultValue) {
		//Logic- what to do
		logger.info("After Returning Aspect - Method is called {}",joinPoint,resultValue);
	}
	
	
}
