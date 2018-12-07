package com.stone.spring.dynamicproxy;

public class Test {
	public static void main(String[] args) {
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		System.out.println(proxy.add(1, 2));
		System.out.println(proxy.div(4, 2));
	}	
}
