package com.springbook.setterannot;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성");
	}

	@Override
	public void volumnUp() {
		System.out.println("AppleSpeaker---소리를 올린다.");
	}

	@Override
	public void volumnDown() {
		System.out.println("AppleSpeaker---소리를 내린다.");
	}

}
