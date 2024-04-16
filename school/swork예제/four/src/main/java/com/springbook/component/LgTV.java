package com.springbook.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tv") @Scope("prototype") @Lazy
public class LgTV implements TV  {
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV---전원을 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV---전원을 끈다.");
	}
	@Override
	public void volumnUp() {
		System.out.println("LgTV---소리를 올린다.");
	}
	@Override
	public void volumnDown() {
		System.out.println("LgTV---소리를 내린다.");
	}
}
