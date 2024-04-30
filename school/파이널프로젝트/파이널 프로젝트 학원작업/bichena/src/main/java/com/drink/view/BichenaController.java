package com.drink.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drink.ko.ProdRevService;
import com.drink.ko.ProdRevVO;
import com.drink.ko.ProdService;
import com.drink.ko.ProdVO;
import com.drink.ko.QnaService;
import com.drink.ko.QnaVO;

@Controller
public class BichenaController {
	@Autowired
	ProdService prodService;
	@Autowired
	ProdRevService prodRevService;
	@Autowired
	QnaService qnaService;

	@GetMapping("/prodList.ko")
	public String prodList(Model model) {
		List<ProdVO> prodList = prodService.prodList();
		model.addAttribute("prodList", prodList);
		return "/WEB-INF/user/prodView.jsp";
	}
	
	@GetMapping("/prodOne.ko")
	public String prodOne(@RequestParam(value="p_no") String p_no, Model model) {
		ProdVO prodOne = prodService.prodOne(p_no);
		model.addAttribute("prodOne", prodOne);
		return "/WEB-INF/user/prodOneView.jsp";
	}
	
	@PostMapping("/prodOneRev.ko")
	@ResponseBody
	public Object prodOneNotice(@RequestParam(value="p_no") String p_no, Model model) {
		List<ProdRevVO> prodOneRev = prodRevService.prodOneRev(p_no);
		model.addAttribute("prodNotice", prodOneRev);
		
		Map<String, Object> prodOneRevMap = new HashMap<>();
		prodOneRevMap.put("code", "OK");
		prodOneRevMap.put("prodOneRev", prodOneRev);
		return prodOneRevMap;
	}
	
	@GetMapping("/qnaList.ko")
	public String qnaList(Model model) {
		List<QnaVO> qnaList = qnaService.qnaList();
		model.addAttribute("qnaList", qnaList);
		return "/WEB-INF/user/qna.jsp";
	}
	
	@GetMapping("/qnaView.ko")
	public String qnaView(@RequestParam(value="q_no") String q_no, Model model) {
		QnaVO qnaView = qnaService.qnaView(q_no);
		model.addAttribute("qnaView", qnaView);
		return "/WEB-INF/user/qnaView.jsp";
	}
	
	@PostMapping("/qnaAcontent.ko")
	public String qnaAcontent(QnaVO vo) {
		int cnt = qnaService.qnaAcontent(vo);
		
		if (cnt > 0) {
			System.out.println("답변완료");
			return "qnaList.ko";
		} else {
			System.out.println("답변실패");
			return "/index.jsp";
		}
	}
	
	@GetMapping("/qnaDelete.ko")
	public String qnaDelete(@RequestParam(value="q_no") String q_no) {
		int cnt = qnaService.qnaDelete(q_no);
		
		if (cnt > 0) {
			System.out.println("삭제완료");
			return "qnaList.ko";
		} else {
			System.out.println("삭제실패");
			return "/index.jsp";
		}
	}
	
	@GetMapping("/qnaInsertbtn.ko")
	public String prodOne() {
		return "/WEB-INF/user/qnaInsert.jsp";
	}
	
}
