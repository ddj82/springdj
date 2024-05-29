package kr.co.biz.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.biz.board.Board;
import kr.co.biz.board.BoardService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FristController {
	private final BoardService service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	@RequestMapping(value="/boards/insert", method=RequestMethod.GET)
	public String insert() {
		return "ajaxInsert";
	}
	
	@RequestMapping(value="/boards/insert", method=RequestMethod.POST)
	public String insert(Board vo) {
		vo.setRegDate(LocalDateTime.now());
        service.save(vo);
		return "redirect:/boards/list";
	}
	
	@RequestMapping("/boards/list")
	public String list(Model model) {
		model.addAttribute("boardList", service.findByBoard());
		return "ajaxList";
	}
}
