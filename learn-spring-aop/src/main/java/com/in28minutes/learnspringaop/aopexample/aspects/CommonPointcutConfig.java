package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
//To simplify pointcut config, so that we need to change at one place only and not everywhere

	@Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learnspringaop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	//match all beans which have service in their names
	@Pointcut("bean(*Service*)")
	public void allServicePackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.in28minutes.learnspringaop.aopexample.annotations.TrackTime)")
	public void TrackTimeAnnotation() {}
}
