package com.springrest.repository;


import java.util.Set;

import org.springframework.stereotype.Repository;

import com.springrest.vo.UserVO;

@Repository
public interface UserRespository {

	public int addUser(UserVO uservo) ;
	public int removeUser(int userId) ;
	public int updateUser(UserVO uservo);
	public UserVO getUser(int userId);
	public Set<UserVO> getAllUsers() ;
}
