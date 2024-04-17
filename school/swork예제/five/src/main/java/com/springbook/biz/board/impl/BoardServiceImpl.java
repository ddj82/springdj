package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")	
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int insertBoard(BoardVO vo) {
		System.out.println("insertBoard 메소드 호출");
//		try {
//			if (vo.getSeq() == 0) {
//				throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다.");
//			} else {
				return dao.insertBoard(vo);
//			}
//		} catch (Exception e) {
//			System.out.println("예외발생");
//		}
//		return 0;
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

}
