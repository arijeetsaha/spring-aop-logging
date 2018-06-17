package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut(value = "execution(* SampleService.*(..))")
	public void allMethods() {

	}

	@Pointcut(value = "execution(* SampleService.get1Method())")
	public void sampleMethods() {

	}

	@Before("sampleMethods() && @annotation(CommonAnnotation)")
	public void startProcess(JoinPoint pjp) throws Throwable {
		LOGGER.debug("Before Advice");
	}

	@After("execution(* com.example.SampleService.get2Method()) && @annotation(CommonAnnotation)")
	public void endProcess(JoinPoint pjp) throws Throwable {
		LOGGER.debug("After Advice");
	}

	@AfterReturning(pointcut = "execution(* com.example.SampleService.get3Method()) && @annotation(CommonAnnotation)", returning = "returnString")
	public void endSuccessProcess(JoinPoint pjp, String returnString) throws Throwable {
		LOGGER.debug("AferReturning Advice : returning : {}", returnString);
	}

	@AfterThrowing(pointcut = "within(com.example.SampleService)")
	public void endExceptionProcess(JoinPoint pjp) throws Throwable {
		LOGGER.debug("After throwing advice");
	}

	/**
	 * Aspect for logging functionality
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("allMethods() && @annotation(LogAnnotation)")
	public Object aroundProcess(ProceedingJoinPoint pjp) throws Throwable {
		long millis = System.currentTimeMillis();
		LOGGER.debug("Around Advice - Before executing method - Inputs: {}", pjp.getArgs());
		Object value = null;
		try {
			value = pjp.proceed();
			// Simulating the method execution time
			Thread.sleep(2000);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("Around Advice - After completion of execution : {} - Input : {}, Output : {}",
				System.currentTimeMillis() - millis, pjp.getArgs(), value);
		return value;
	}

}
