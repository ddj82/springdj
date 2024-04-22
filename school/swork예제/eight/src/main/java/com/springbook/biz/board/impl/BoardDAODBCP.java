package com.springbook.biz.board.impl;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	sql명령어들
	private final String BOAED_INSERT = "insert into board(title, writer, content) values(?, ?, ?)";
	private final String BOAED_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOAED_DELETE = "delete from board where seq = ?";
	private final String BOAED_GET = "select * from board where seq = ?";
	
//	CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 insertBoard() 기능처리");
		jdbcTemplate.update(BOAED_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
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
			Object[] args = {vo.getSeq()};
			return jdbcTemplate.queryForObject(BOAED_GET, new BoardRowMapper(), args);
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo, String keyword, String condition) {
		System.out.println("===> Spring jdbcTemplate으로 getBoardList() 기능처리");
		Object[] args = new Object[1];
		String BOARD_LIST = "SELECT * FROM BOARD WHERE 1 = 1";
		
		if (!keyword.equals("") && !condition.equals("")) {
			if (condition.equals("CONTENT")) {
				BOARD_LIST += " AND CONTENT LIKE CONCAT('%', ?, '%')";
//				args[0] = vo.getContent();
				args[0] = keyword;
			} else {
				BOARD_LIST += " AND TITLE LIKE CONCAT('%', ?, '%')";
//				args[0] = vo.getTitle();
				args[0] = keyword;
			}
		} else {
			args = null;
		}
		
		BOARD_LIST += " ORDER BY SEQ DESC";
		
		System.out.println("BOARD_LIST : " + BOARD_LIST);
		
		
		if (args == null) {
			if (jdbcTemplate.query(BOARD_LIST, new BoardRowMapper()).isEmpty()) {
				return null;
			} else {
				return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
			}
		} else {
			System.out.println("args[0] : " + args[0]);
			if (jdbcTemplate.query(BOARD_LIST, new BoardRowMapper(), args).isEmpty()) {
				return null;
			} else {
				return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper(), args);
			}
		}
	}
}
