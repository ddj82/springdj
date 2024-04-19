package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	public int inserUser(UserVO vo);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);
	
	public UserVO getUser(UserVO vo);
	public UserVO selectOne(UserVO vo);
	public List<UserVO> selectList(String keyword);
}
