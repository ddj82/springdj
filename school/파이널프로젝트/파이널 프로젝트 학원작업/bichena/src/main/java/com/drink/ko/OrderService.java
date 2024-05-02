package com.drink.ko;

import java.util.List;

public interface OrderService {
	List<OrderVO> myOrderList(int u_no);
	OrderVO myOrderDetail(String o_no);
	int orderRevchk(OrderVO vo);
}
