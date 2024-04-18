package com.springbook.biz.board.impl;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository
public class BoardDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	sql명령어들
	private final String BOAED_INSERT = "insert into board(title, writer, content) values(?, ?, ?)";
	private final String BOAED_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOAED_DELETE = "delete from board where seq = ?";
	private final String BOAED_GET = "select * from board where seq = ?";
	private final String BOAED_LIST = "select * from board order by seq desc";
	
//	CRUD 기능의 메소드 구현
	// 글 등록
	public int insertBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 insertBoard() 기능처리");
		return jdbcTemplate.update(BOAED_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 updateBoard() 기능처리");
		jdbcTemplate.update(BOAED_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOAED_DELETE, vo.getSeq());
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 getBoard() 기능처리");
		try {
//			Object[] args = {vo.getSeq()};
//			return jdbcTemplate.queryForObject(BOAED_GET, new BoardRowMapper(), args);
			return jdbcTemplate.queryForObject(BOAED_GET, new BoardRowMapper(), vo.getSeq());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 getBoardList() 기능처리");
		try {
			return jdbcTemplate.query(BOAED_LIST, new BoardRowMapper());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}
}
