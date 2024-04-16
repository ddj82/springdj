package com.springbook.setterannot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stv")
public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV() 객체 생성");
	}
	
//	@Autowired
//	public SamsungTV(Speaker speaker) {
//		System.out.println("===> SamsungTV(speaker) 객체 생성");
//		this.speaker = speaker;
//		this.price = 75000;
//	}
	
//	@Autowired
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("===> SamsungTV(speaker,price) 객체 생성");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	@Autowired
	public void setTwo(Speaker speaker, int price) {
		System.out.println("===> SamsungTV setTwo(speaker,price) 메소드 호출");
		this.speaker = speaker;
		this.price = price;
	}
	
//	@Autowired
//	public void setTwo(@Qualifier("apple") Speaker speaker, int price) {
//		System.out.println("===> SamsungTV setTwo(speaker,price) 메소드 호출");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원을 켠다. (가격: " + price + ")");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}
	@Override
	public void volumnUp() {
		speaker.volumnUp();
		System.out.println("SamsungTV---소리를 올린다.");
	}
	@Override
	public void volumnDown() {
		speaker.volumnDown();
		System.out.println("SamsungTV---소리를 내린다.");
	}
	
}
