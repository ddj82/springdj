package com.kr.co;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {
	
	@Bean(initMethod = "initSamsung")
	public Samsung stv() {
		Samsung s = new Samsung();
		return s;
	}
	
//	@Bean
//	public Greeter greeter() {
//		Greeter g = new Greeter("0");
//		g.setFormat("%s, 안녕하세요!");
//		return g;
//	}
	
	@Bean @Scope("prototype")
	public Greeter greeter() {
		Greeter g = new Greeter("0");
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
	
//	@Bean
//	public Greeter greeter1() {
//		Greeter g = new Greeter("1");
//		g.setFormat("%s, 시작합니다!");
//		return g;
//	}
	
//	@Lazy만 기술되면 lazy-init="true" (게으른로딩=지연로딩)
	@Bean @Lazy
	public Greeter greeter1() {
		Greeter g = new Greeter("1");
		g.setFormat("%s, 시작합니다!");
		return g;
	}
	
	@Bean
	public int inter() {
		return 50;
	}
}
