package com.drink.ko.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.drink.ko.biz.product.ProductService;
import com.drink.ko.biz.product.ProductVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/insertProduct.ko")
	public String insertProduct(ProductVO vo) {
		productService.insertProduct(vo);
		return "selectProduct.ko";
	}
	
	@RequestMapping("/selectProduct.ko")
	public ModelAndView selectProductAll(ProductVO vo, ModelAndView mav) {
		mav.addObject("productList", productService.selectProductAll(vo));
		System.out.println(mav.getModel());
		mav.setViewName("WEB-INF/user/one.jsp");
		return mav;
	}
}
