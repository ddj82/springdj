package com.springbook.component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppContext.class);
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
//		TV tv = (TV) factory.getBean("lgTV");
		TV tv = (TV) factory.getBean("tv");
//		System.out.println("tv : " + tv);
		
//		tv = (TV) factory.getBean("tv");
//		System.out.println("tv : " + tv);
		
//		tv = (TV) factory.getBean("tv");
//		System.out.println("tv : " + tv);
		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
//		
		tv = (TV) factory.getBean("stv");
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
		//3. Spring 컨테이너를 종료한다.
		factory.close();
	}

}
