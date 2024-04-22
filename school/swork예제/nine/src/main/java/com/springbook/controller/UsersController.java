package com.springbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.bus.UserService;
import com.springbook.biz.bus.UsersVO;

@Controller
public class UsersController {
	@Autowired
	UserService svc;
	
	@RequestMapping(value = "/insertUser.do", method = RequestMethod.POST)
	public String insertUser(UsersVO vo) {
		System.out.println("입력요소 담은 vo : " + vo);
		String str = "";
		int cnt = svc.insertUser(vo);
		if (cnt > 0) {
			System.out.println("성공");
			str = "OK";
		} else {
			System.out.println("실패");
			str = "NO";
		}
		
		return "redirect:index.jsp?result=" + str;
//		index.jsp?result=OK
	}
}
