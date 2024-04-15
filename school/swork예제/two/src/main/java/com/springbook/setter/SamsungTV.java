package com.springbook.setter;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV() 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	@Autowired
	public void setTwo(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	@Override
	public int getPrice() {
		System.out.println("===> getPrice() 호출 : " + price);
		return price;
	}
	
	@Override
	public void powerOn() {
		System.out.printf("SamsungTV ---전원을 켠다. (가격: %,d원) \n", price);
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV ---전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("SamsungTV ---소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("SamsungTV ---소리를 내린다.");
	}
	
}
