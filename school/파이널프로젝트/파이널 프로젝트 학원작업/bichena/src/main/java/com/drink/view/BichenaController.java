package com.drink.view;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "/WEB-INF/user/prodView.jsp";
	}
	
	@GetMapping("prodOne.do")
	public String prodOne(@RequestParam(value="p_no") String pno, Model model) {
		ProdVO prodOne = prodService.prodOne(pno);
		model.addAttribute("prodOne", prodOne);
		return "/WEB-INF/user/prodOneView.jsp";
	}
	
	
	@PostMapping("prodOneNotice.do")
	@ResponseBody
	public Object prodOneNotice(@RequestParam(value="p_no") String pno, Model model) {
		List<ProdNoticeVO> prodNotice = prodNoticeService.prodOneNotice(pno);
		model.addAttribute("prodNotice", prodNotice);
		System.out.println(prodNotice.get(0));
		
		Map<String, Object> prodNoticeMap = new HashMap<>();
		prodNoticeMap.put("code", "OK");
		prodNoticeMap.put("prodNotice", prodNotice);
		return prodNoticeMap;
	}
	
	
}
