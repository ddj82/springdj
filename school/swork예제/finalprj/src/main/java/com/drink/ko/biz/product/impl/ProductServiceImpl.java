package com.drink.ko.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drink.ko.biz.product.ProductService;
import com.drink.ko.biz.product.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO dao;

	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}

	@Override
	public List<ProductVO> selectProductAll(ProductVO vo) {
		return dao.selectProductAll(vo);
	}
	
}
