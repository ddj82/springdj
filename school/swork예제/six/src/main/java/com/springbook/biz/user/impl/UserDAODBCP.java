package com.springbook.biz.user.impl;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ?, NAME = ? WHERE ID = ?";
	private final String USER_DELETE = "DELETE FROM USERS WHERE ID = ?";
	private final String USER_GET = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?"; 
	private final String SELECT_ONE = "SELECT * FROM USERS WHERE ID = ?";
	private final String SELECT_LIST = "SELECT * FROM USERS ORDER BY ID";
	
	public int insertUser(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 insertUser() 기능처리");
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		return jdbcTemplate.update(USER_INSERT, args);
	}
	
	public void updateUser(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 updateUser() 기능처리");
		Object[] args = {vo.getPassword(), vo.getName(), vo.getId()};
		jdbcTemplate.update(USER_UPDATE, args);
	}
	
	public void deleteUser(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 deleteUser() 기능처리");
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 getUser() 기능처리");
//		if (jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), vo.getId(), vo.getPassword()) == null) {
//			return null;
//		} else {
//			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), vo.getId(), vo.getPassword());
//		}
		
		try {
			return jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), vo.getId(), vo.getPassword());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}
	
	public UserVO selectOne(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 selectOne() 기능처리");
//		if (jdbcTemplate.queryForObject(SELECT_ONE, new UserRowMapper(), vo.getId()) == null) {
//			return null;
//		} else {
//			return jdbcTemplate.queryForObject(SELECT_ONE, new UserRowMapper(), vo.getId());
//		}
		
		try {
			return jdbcTemplate.queryForObject(SELECT_ONE, new UserRowMapper(), vo.getId());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}
	
	public List<UserVO> selectList(UserVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 selectList() 기능처리");
		if (jdbcTemplate.query(SELECT_LIST, new UserRowMapper()).isEmpty()) {
			return null;
		} else {
			return jdbcTemplate.query(SELECT_LIST, new UserRowMapper());
		}
		
//		try {
//			return jdbcTemplate.query(SELECT_LIST, new UserRowMapper());
//		} catch (EmptyResultDataAccessException err) {
//			return null;
//		}
	}
}
