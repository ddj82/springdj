package com.springbook.biz.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usv")
public class UserService {
	//dao클래스 객체 자동주입처리하기
	@Autowired
	UserDAO dao;
	
	public int insertUser(UsersVO vo) {
		return dao.insertUser(vo);
	}

}
