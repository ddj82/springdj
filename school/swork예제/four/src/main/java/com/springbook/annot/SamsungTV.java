package com.springbook.annot;


public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV() 객체 생성");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV ---전원을 켠다. (가격: " + price + ")");
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
