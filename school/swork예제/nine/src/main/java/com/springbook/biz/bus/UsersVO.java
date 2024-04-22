package com.springbook.biz.bus;

public class UsersVO {
	private String id; //user4
	private String password; //1111
	private String name; //정씨
	private String role; //전사
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UsersVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
}
