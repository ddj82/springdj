package com.springbook.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {
	SonySpeaker sony = new SonySpeaker();
	
	@Bean
	public LgTV tv() {
		return new LgTV();
	}
	
//	생성자 주입
	@Bean
	public SamsungTV stv() {
		return new SamsungTV(sony, 170000);
	}
	
//	setter 주입
//	@Bean
//	public SamsungTV stv() {
//		SamsungTV s = new SamsungTV();
//		s.setSpeaker(apple());
//		s.setPrice(300000);
//		return s;
//	}
	
	@Bean
	public AppleSpeaker apple() {
		return new AppleSpeaker();
	}
	
}
