package com.drink.ko.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drink.ko.ProdNoticeService;
import com.drink.ko.ProdNoticeVO;

@Service
public class ProdNoticeServiceImpl implements ProdNoticeService {
	@Autowired
	ProdNoticeDAO dao;

	@Override
	public List<ProdNoticeVO> prodOneNotice(String pno) {
		return dao.prodOneNotice(pno);
	}
}
