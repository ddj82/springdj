package com.springbook.view.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

@Controller
public class TestController {
	@Autowired
	private BoardService boardService;
	
	/* @RequestBody
	 * 이 어노테이션이 붙은 파라미터에는 http요청의 본문(body)이 그대로 전달된다.
	 * 일반적인 GET/POST의 요청 파라미터라면 @RequsetBody를 사용할 일이 없다.
	 * 반면에 xml이나 json기반의 메세지를 사용하는 요청의 경우에 이 방법이 매우 유용하다.
	 * HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달해준다.
	 * 
	 * @ResponseBody
	 * 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송한다.
	 * **jackson-databind 라이브러리가 있는 경우 @ResponseBody를 사용하여
	 * 데이터를 전송하면 데이터의 타입을 확인하여 자동으로 JsonArray나 JsonObject자료형으로 변환하여 반환해준다.
	 * 
	 * 참고사이드 : https://cheershennah.tistory.com/179
	 * 
	 * */
	
	@RequestMapping(value = "/ajaxTest.do", produces = "application/text; charset=utf-8")
//	@RequestMapping("/ajaxTest.do")
	@ResponseBody
//	public String ajaxTest(UserVO vo) throws Exception {
	public String ajaxTest(@RequestBody UserVO vo) throws Exception {
		System.out.println(vo);
//		return "OK";
		return "성공";
	}
	
//	@RequestMapping(value = "/ajaxTest.do")
//	@ResponseBody
//	public Object ajaxTest(@RequestBody UserVO vo) throws Exception {
//		System.out.println(vo);
//		Map<String, Object> retVal = new HashMap<>();
//		retVal.put("code", "성공");
//		return retVal;
//	}
	
	@ResponseBody
	@RequestMapping("/test.do")
	public String testView() {
		System.out.println("test 처리");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now);
//		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		Date day = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatedNow = sdf.format(day);
		
		return formatedNow;
	}
	
	@RequestMapping("/reqAjax1.do")
	@ResponseBody
	public List<BoardVO> reqAjax1(BoardVO vo) {
		System.out.println("reqAjax1 처리");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
	@RequestMapping("/reqAjax2.do")
	@ResponseBody
	public Object reqAjax2(BoardVO vo) {
		System.out.println("reqAjax2 처리");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		Map<String, Object> retVal = new HashMap<>();
		retVal.put("code", "OK");
		retVal.put("boardList", boardList);
		
		return retVal;
	}
	

}
