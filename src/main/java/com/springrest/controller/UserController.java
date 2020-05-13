package com.springrest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.service.UserService;
import com.springrest.vo.UserVO;

@RestController//(@Controller +@ResponseBody)

@RequestMapping("/v1")
public class UserController {
	@Autowired
	private UserService userservice;//setter injection
	
	public UserController() {
		super();
		System.out.println("Constructor called---------");
		//this.userservice = userservice;
	}
	
	//@RequestMapping(method = RequestMethod.POST,name = "/adduser",consumes = "json,xml",produces = "json,xml")
	@PostMapping("/user")
	public int addUser(@RequestBody UserVO uservo) {
		return userservice.addUser(uservo);
	}
	
	@DeleteMapping("/user/{id}")
	public int removeUser(@PathVariable("id") int userId) {
		
		return userservice.removeUser(userId);
	}
	
	@PutMapping("/user")
	public int updateUser(@RequestBody UserVO uservo) {
		return userservice.updateUser(uservo);
	}
	@GetMapping("/user/{id}")
	public UserVO getUser(@PathVariable("id") int userId) {
		return userservice.getUser(userId);
	}
	@GetMapping("/user")
	public Set<UserVO> getAllUsers() {
		return userservice.getAllUsers();
	}

}
