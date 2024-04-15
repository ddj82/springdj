package com.springbook.annot;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
//		1. Spring 컨테이너를 구동한다.
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext1.xml");
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext2.xml");
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("annotContext.xml");
		
//		2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
//		TV tv = (TV) factory.getBean("tv");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		3. Spring 컨테이너를 종료한다.
//		factory.close();
		int[] numbers = new int[5];
		int[] a = numbers.length % 2 == 0 ? new int[numbers.length / 2] : new int[(numbers.length / 2) + 1];
		System.out.println(a.length);
	}

}
