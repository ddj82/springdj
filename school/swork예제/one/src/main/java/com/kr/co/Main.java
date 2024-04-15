package com.kr.co;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// AnnotationConfigApplictionContext 자바 설정 정보를 읽어오는 클래스
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
//		Greeter g = (Greeter) ctx.getBean("greeter");
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		
		String msg = g.greet("스프링");
		System.out.println("msg : " + msg);
		String msg1 = g1.greet("스프링1");
		System.out.println("msg1 : " + msg1);
		
		System.out.println("g.str : " + g.str);
		System.out.println("g1.str : " + g1.str);
		
		Greeter s1 = ctx.getBean("greeter1", Greeter.class);
		msg = s1.greet("스프링");
		System.out.println("msg : " + msg);
		int i = ctx.getBean("inter", Integer.class);
		System.out.println("i의 값 : " + i);
		
		System.out.println("g객체 : " + g);
		System.out.println("g1객체 : " + g1);
		System.out.println("s1객체 : " + s1);
		System.out.println("g == g1 : " + (g == g1));
		System.out.println("g == s1 : " + (g == s1));
		
		TV tv = (TV) ctx.getBean("stv");
		tv.powerOn();
		ctx.close();
	}

}
