package com.springbook.view.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//@Component
@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	String realPath = "C:/swork/eight/src/main/webapp/img/";
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		return conditionMap;
	}
	
//	상대경로 추가 시
//	글 등록
	@PostMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
//	public String insertBoard(MultipartHttpServletRequest request, BoardVO vo) throws IllegalStateException, IOException {
		MultipartFile uploadFile = vo.getUploadFile();
//		상대경로 추가 시 realPath 추가
//		realPath = request.getSession().getServletContext().getRealPath("/img/");
		File f = new File(realPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		String fileName = uploadFile.getOriginalFilename();
		
		if (!uploadFile.isEmpty()) {
			vo.setFilename(fileName);
			
			//실질적으로 파일이 설정한 경로에 업로드 되는 지점
			uploadFile.transferTo(new File(realPath + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
//	파일 다운로드
	@GetMapping(value = "/download.do")
	public void fileDownLoad(@RequestParam(value = "filename", required = false) String filename, HttpServletResponse response) throws IOException {
//	public void fileDownLoad(@RequestParam(value = "filename", required = false) String filename, 
//			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("파일 다운로드");
		if (!(filename == null || filename.equals(""))) {
//			요청파일 정보 불러오기
//			realPath = request.getSession().getServletContext().getRealPath("/img/");
			File file = new File(realPath + filename);
			
//			한글은 http 헤더에 사용할 수 없기 때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다.
			String fn = new String(file.getName().getBytes(), "iso_8859_1");
			
//			ContextType 설정
			byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(file);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\"");
			response.setContentLength(bytes.length);
//			response.setContentType("image/jpeg");
			
			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}
	}
	
	
//	글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpSession session) {
		System.out.println(vo);
		if (vo.getWriter().equals(session.getAttribute("userName").toString())) {
			boardService.updateBoard(vo);
			return "getBoardList.do";
		} else {
			return "getBoard.do?error=1";
		}
	}
	
//	글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
//	글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // 여기서 @SessionAttributes("board") 객체생성
//		request.setAttribute("board", boardService.getBoard(vo));
		return "WEB-INF/board/getBoard.jsp";
	}
	
//	글 목록
//	@RequestMapping("/getBoardList.do")
//	public String getBoardListPost(BoardVO vo, Model model) {
//		System.out.println("글 목록 검색 처리");
//		
//		model.addAttribute("boardList", boardService.getBoardList(vo));
//		return "WEB-INF/board/getBoardList.jsp";
//	}
	
//	글 목록
	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardListPost(BoardVO vo, 
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition, 
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, ModelAndView mav) {
	public ModelAndView getBoardListPost(BoardVO vo, ModelAndView mav) {
		if (vo.getTitle() == null) {
			vo.setTitle("");
		}
		
//		System.out.println("글 목록 검색 처리 : " + condition + ", " + keyword);
		mav.addObject("boardList", boardService.getBoardList(vo));
		mav.setViewName("WEB-INF/board/getBoardList.jsp");
		return mav;
	}
	
}
