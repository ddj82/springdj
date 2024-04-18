package com.springbook.biz.board.impl;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
//	JDBC관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
//	sql명령어들
//	private final String BOAED_INSERT = "insert into board(seq, title, writer, content) "
//			+ "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOAED_INSERT = "insert into board(title, writer, content) "
			+ "values(?, ?, ?)";
	private final String BOAED_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOAED_DELETE = "delete from board where seq = ?";
	private final String BOAED_GET = "select * from board where seq = ?";
	private final String BOAED_LIST = "select * from board order by seq desc";
	
//	CRUD 기능의 메소드 구현
	// 글 등록
	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능처리");
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOAED_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("완료");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return cnt;
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOAED_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOAED_GET);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOAED_DELETE);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			while (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능처리");
		List<BoardVO> boardList = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOAED_LIST);
			rs = stmt.executeQuery();
			if (rs.next()) {
				boardList = new ArrayList<>();
				do {
					BoardVO board = new BoardVO();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getDate("regdate"));
					board.setCnt(rs.getInt("cnt"));
					boardList.add(board);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}
