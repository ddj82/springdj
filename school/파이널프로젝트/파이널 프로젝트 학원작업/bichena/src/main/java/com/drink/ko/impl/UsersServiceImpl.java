package com.drink.ko.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drink.ko.UsersService;
import com.drink.ko.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersDAO dao;

	@Override
	public UsersVO loginSelectOne(UsersVO vo) {
		return dao.loginSelectOne(vo);
	}
}
