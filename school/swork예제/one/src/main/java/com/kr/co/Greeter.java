package com.kr.co;

public class Greeter {
	public String format;
	public String str;
	
	public Greeter(String str) {
		System.out.println("Greeter" + str + " 생성자 호출");
	}
	
	public String greet(String guest) {
		str = guest;
		return String.format(format, guest);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
}
