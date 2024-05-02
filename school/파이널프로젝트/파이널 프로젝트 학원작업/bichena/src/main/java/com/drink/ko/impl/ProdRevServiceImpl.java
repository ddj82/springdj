package com.drink.ko.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drink.ko.ProdRevService;
import com.drink.ko.ProdRevVO;

@Service
public class ProdRevServiceImpl implements ProdRevService {
	@Autowired
	ProdRevDAO dao;

	@Override
	public List<ProdRevVO> prodOneRev(String p_no) {
		return dao.prodOneRev(p_no);
	}

	@Override
	public int prodRevInsert(ProdRevVO vo) {
		return dao.prodRevInsert(vo);
	}
}
