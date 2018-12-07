package com.stone.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 1.创建Spring的IoC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2.从IoC容器获取bean的实例
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");

		// 3.使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result: " + result);
		
		result = arithmeticCalculator.div(12, 2);
		System.out.println("result: " + result);
	}

}
