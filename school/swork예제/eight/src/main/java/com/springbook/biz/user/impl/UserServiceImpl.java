package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
//	@Autowired
//	private UserDAODBCP dao;
	
	@Autowired
	private UserDAOMybatis dao;

	@Override
	public int inserUser(UserVO vo) {
		return dao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		dao.deleteUser(vo);
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

//	@Override
//	public UserVO selectOne(UserVO vo) {
//		return dao.selectOne(vo);
//	}
	
	@Override
	public UserVO selectOne(String selId) {
		return dao.selectOne(selId);
	}

	@Override
	public List<UserVO> selectList(String keyword) {
		return dao.selectList(keyword);
	}

}
