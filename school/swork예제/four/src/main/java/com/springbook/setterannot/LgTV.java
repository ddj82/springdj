package com.springbook.setterannot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV  {
//	@Resource(name="apple")
	@Autowired @Qualifier("apple")
	private Speaker speaker;
	
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
		speaker.volumnUp();
		System.out.println("LgTV---소리를 올린다.");
	}
	@Override
	public void volumnDown() {
		speaker.volumnDown();
		System.out.println("LgTV---소리를 내린다.");
	}
}
