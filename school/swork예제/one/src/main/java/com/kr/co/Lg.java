package com.kr.co;

public class Lg implements TV{
	public Lg() {
		System.out.println("LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("l전원 켜기");
	}
	
	@Override
	public void powerOff() {
		System.out.println("l전원 끄기");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("l볼륨 올리기");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("l볼륨 낮추기");
	}
	
}
