package com.springbook.biz.board;
import java.util.*;

import com.springbook.biz.common.JDBCUtil;

public interface BoardService {
	// 글 등록
	int insertBoard(BoardVO vo);
	
	// 글 수정
	void updateBoard(BoardVO vo);
	
	// 글 삭제
	void deleteBoard(BoardVO vo);
	
	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);
	
	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);
}
