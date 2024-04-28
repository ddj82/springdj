package com.drink.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drink.ko.ProdNoticeService;
import com.drink.ko.ProdNoticeVO;
import com.drink.ko.ProdService;
import com.drink.ko.ProdVO;

@Controller
public class BichenaController {
	
	@Autowired
	ProdService prodService;
	
	@Autowired
	ProdNoticeService prodNoticeService;
	

	@GetMapping("prodList.do")
	public String prodList(Model model) {
		List<ProdVO> prodList = prodService.prodList();
		model.addAttribute("prodList", prodList);
		System.out.println(prodList);
		return "/WEB-INF/user/prodView.jsp";
	}
	
	@GetMapping("prodOne.do")
	public String prodOne(@RequestParam(value="p_no") String pno, Model model) {
		ProdVO prodOne = prodService.prodOne(pno);
		model.addAttribute("prodOne", prodOne);
		return "prodOneNotice.do";
	}
	
//	@RequestMapping("prodOne.do")
//	@ResponseBody
//	public Object prodOne(ProdVO vo, Model model) {
//		ProdVO prodOne = prodService.prodOne(String.valueOf(vo.getP_no()));
//		model.addAttribute("prodOne", prodOne);
//		Map<String, Object> prodMap = new HashMap<>();
//		prodMap.put("code", "OK");
//		return prodMap;
//	}
	
	@GetMapping("prodOneNotice.do")
	public String prodOneNotice(ProdNoticeVO vo, Model model) {
		System.out.println("prodOneNotice탐");
		System.out.println("prodOneNotice에서 pno = " + String.valueOf(vo.getP_no()));
		List<ProdNoticeVO> prodNotice = prodNoticeService.prodOneNotice(String.valueOf(vo.getP_no()));
		model.addAttribute("prodNotice", prodNotice);
		return "/WEB-INF/user/prodOneView.jsp";
	}
	
	
}
