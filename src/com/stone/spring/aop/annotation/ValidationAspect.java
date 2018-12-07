package com.stone.spring.aop.annotation;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//可以使用@Order指定切面的优先级，值越小优先级越高
@Order(1)
public class ValidationAspect {
	@Before("LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
