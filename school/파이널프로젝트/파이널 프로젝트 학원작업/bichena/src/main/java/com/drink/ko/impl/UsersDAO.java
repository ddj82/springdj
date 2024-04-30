package com.drink.ko.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drink.ko.UsersVO;

@Repository
public class UsersDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public UsersVO loginSelectOne(UsersVO vo) {
		return mybatis.selectOne("userDAO.loginSelectOne", vo);
	}
}
