package com.drink.ko.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drink.ko.OrderService;
import com.drink.ko.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO dao;

	@Override
	public List<OrderVO> myOrderList(int u_no) {
		return dao.myOrderList(u_no);
	}

	@Override
	public OrderVO myOrderDetail(String o_no) {
		return dao.myOrderDetail(o_no);
	}

	@Override
	public int orderRevchk(OrderVO vo) {
		return dao.orderRevchk(vo);
	}
}
