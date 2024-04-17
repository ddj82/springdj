package com.springbook.biz.board;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목aop");
		vo.setWriter("홍길동aop");
		vo.setContent("임시내용aop.....");
		try {
			int cnt = boardService.insertBoard(vo);
			System.out.println(cnt);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("에러메세지 : " + e.getMessage());
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
		container.close();
	}
	
}
