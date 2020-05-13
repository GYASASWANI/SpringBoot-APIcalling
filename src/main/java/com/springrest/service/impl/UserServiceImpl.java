package com.springrest.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.repository.UserRespository;
import com.springrest.service.UserService;
import com.springrest.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRespository userRespository;//setter injection
	
	@Override
	public int addUser(UserVO uservo) {
		return userRespository.addUser(uservo);
	}

	@Override
	public int removeUser(int userId) {

		return userRespository.removeUser(userId);
	}

	@Override
	public int updateUser(UserVO uservo) {
	
		return userRespository.updateUser(uservo);
	}

	@Override
	public UserVO getUser(int userId) {
		
		return userRespository.getUser(userId);
		//return null;
	}

	@Override
	public Set<UserVO> getAllUsers() {
	
		return userRespository.getAllUsers();
	}

}
