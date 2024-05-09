package com.drink.ko;

import java.util.List;

import com.drink.ko.vo.ProdVO;

public interface ProdService {
	ProdVO prodOne(String p_no);
	List<ProdVO> prodList();
	int adminProdInsert(ProdVO vo);
	
	public int getPnoMaxNum();
	public int insertProduct(ProdVO vo);
}
