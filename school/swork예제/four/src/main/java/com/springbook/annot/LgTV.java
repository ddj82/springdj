package com.springbook.annot;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class LgTV implements TV{
//	@Autowired @Qualifier("apple")
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV ---전원을 켠다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV ---전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV ---소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("LgTV ---소리를 내린다.");
	}
	
}
