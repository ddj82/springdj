package com.springbook.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.springbook.component")
public class AppContext {

//		@Bean
//		public LgTV tv() {
//			return new LgTV();
//		}
		
		@Bean
		public SamsungTV stv() {
			return new SamsungTV();
		}
		
		@Bean
		public int price() {
			System.out.println("===> price(Integer) 객체 생성");
			return 500000;
		}
}
