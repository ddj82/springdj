package com.drink.ko;

import java.util.Date;

public class ProdNoticeVO {
	private int pn_no;
	private int u_no;
	private String u_name;
	private int p_no;
	private String p_name;
	private String pn_content;
	private Date pn_date;
	private String pn_img;
	
	public int getPn_no() {
		return pn_no;
	}
	public void setPn_no(int pn_no) {
		this.pn_no = pn_no;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getPn_content() {
		return pn_content;
	}
	public void setPn_content(String pn_content) {
		this.pn_content = pn_content;
	}
	public Date getPn_date() {
		return pn_date;
	}
	public void setPn_date(Date pn_date) {
		this.pn_date = pn_date;
	}
	public String getPn_img() {
		return pn_img;
	}
	public void setPn_img(String pn_img) {
		this.pn_img = pn_img;
	}
	
	@Override
	public String toString() {
		return "ProdNoticeVO [pn_no=" + pn_no + ", u_no=" + u_no + ", u_name=" + u_name + ", p_no=" + p_no + ", p_name="
				+ p_name + ", pn_content=" + pn_content + ", pn_date=" + pn_date + ", pn_img=" + pn_img + "]";
	}
	
}
