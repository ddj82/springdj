package com.springbook.biz.board;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("JdbcTemplate 테스트");
		vo.setWriter("홍길동");
		vo.setContent("JdbcTemplate 테스트입니다.");
		boardService.insertBoard(vo);
		
		vo.setSeq(20);
		System.out.println("\ngetBoard(20) 데이터");
		System.out.println(boardService.getBoard(vo));
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("\n===> " + board.toString());
		}
		
		container.close();
	}
	
}
