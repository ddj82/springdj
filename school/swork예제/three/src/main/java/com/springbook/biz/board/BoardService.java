package com.springbook.biz.board;
import java.util.*;

import com.springbook.biz.common.JDBCUtil;

public interface BoardService {
	// 글 등록
	public void insertBoard(BoardVO vo);
	
	// 글 수정
	public void updateBoard(BoardVO vo);
	
	// 글 삭제
	public void deleteBoard(BoardVO vo);
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo);
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo);
}
