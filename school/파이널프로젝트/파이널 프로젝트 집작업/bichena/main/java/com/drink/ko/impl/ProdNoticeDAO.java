package com.drink.ko.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drink.ko.ProdNoticeVO;

@Repository
public class ProdNoticeDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<ProdNoticeVO> prodOneNotice(String pno) {
		return mybatis.selectList("ProdNoticeDAO.prodOneNotice", pno);
	}
}
