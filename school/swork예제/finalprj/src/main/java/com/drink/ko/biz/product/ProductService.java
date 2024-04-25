package com.drink.ko.biz.product;

import java.util.List;

public interface ProductService {
	void insertProduct(ProductVO vo);
	List<ProductVO> selectProductAll(ProductVO vo);
}
