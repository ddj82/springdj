package com.kr.co;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		// GenericXmlApplicationContext 파일시스템이나 클래스 경로에 있는 xml설정 파일을 로딩하여 구동하는 컨테이너 클래스
		// GenericXmlApplicationContext이 인식하는 경로 : src/main/resources/ 까지 자동으로 인식함.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// ㄴ위 코드가 하는 일
		// 1. 스프링 컨테이너 구동
		// 2. Spring Bean Configuration file을 읽어들인다.
		// 3. 빈 설정 파일에 기술되어 있는 빈 객체를 생성하여 컨테이너에 모아둔다.
		// 4. 객체를 주입해야 하는 부분에 자동으로 객체 주입을 진행한다.
		
		TV tv = (TV) factory.getBean("http://stv");
		tv = (TV) factory.getBean("http://stv");
		tv = (TV) factory.getBean("http://stv");
		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		System.out.println("\n---------------------------------\n");
		
		tv = (TV) factory.getBean("ltv");
		tv = (TV) factory.getBean("ltv");
		tv = (TV) factory.getBean("ltv");
		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		factory.close();
	}

}
