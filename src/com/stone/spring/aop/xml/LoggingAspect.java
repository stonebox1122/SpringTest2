package com.stone.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void declareJointPointExpression() {}
	
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}
	
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		String methodName = pjp.getSignature().getName();
		
		
		try {
			//前置通知
			System.out.println("The aroundmethod " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
			//执行目标方法
			result = pjp.proceed();
			//返回通知
			System.out.println("The aroundmethod " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The aroundmethod " + methodName + " occurs exception " + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The aroundmethod " + methodName + " ends");
		
		return result;
	}
}