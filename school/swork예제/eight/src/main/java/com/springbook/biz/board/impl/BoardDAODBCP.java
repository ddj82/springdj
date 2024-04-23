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
	private final String BOAED_INSERT = "INSERT INTO BOARD(TITLE, WRITER, CONTENT, FILENAME) VALUES(?, ?, ?, ?)";
	private final String BOAED_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOAED_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOAED_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	
//	CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 insertBoard() 기능처리");
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getFilename()};
		jdbcTemplate.update(BOAED_INSERT, args);
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 updateBoard() 기능처리");
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(BOAED_UPDATE, args);
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
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring jdbcTemplate으로 getBoardList() 기능처리");
		Object[] args = new Object[1];
		String BOARD_LIST = "SELECT * FROM BOARD WHERE 1 = 1";
		
		if (!vo.getSearchKeyword().equals("") && !vo.getSearchCondition().equals("")) {
			if (vo.getSearchCondition().equals("CONTENT")) {
				BOARD_LIST += " AND CONTENT LIKE CONCAT('%', ?, '%')";
				args[0] = vo.getSearchKeyword();
			} else {
				BOARD_LIST += " AND TITLE LIKE CONCAT('%', ?, '%')";
				args[0] = vo.getSearchKeyword();
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
