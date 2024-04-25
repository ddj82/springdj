package com.drink.ko.biz.product;

public class ProductVO {
	private int pd_seq;
	private String pd_name;
	
	public int getPd_seq() {
		return pd_seq;
	}
	public void setPd_seq(int pd_seq) {
		this.pd_seq = pd_seq;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pd_seq=" + pd_seq + ", pd_name=" + pd_name + "]";
	}
	
}
