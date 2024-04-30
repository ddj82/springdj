package com.drink.ko;

import java.util.List;

public interface ProdService {
	ProdVO prodOne(String p_no);
	List<ProdVO> prodList();
}
