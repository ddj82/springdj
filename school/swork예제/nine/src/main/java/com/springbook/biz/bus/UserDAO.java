package com.springbook.biz.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	//JdbcTemplate 연결객체 자동주입처리하기
	@Autowired
	JdbcTemplate jdb;
	
	public int insertUser(UsersVO vo) {
		String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		return jdb.update(sql, args);
	}
}
