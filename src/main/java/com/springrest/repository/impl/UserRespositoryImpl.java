package com.springrest.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springrest.repository.UserRespository;
import com.springrest.vo.UserVO;

@Repository
public class UserRespositoryImpl implements UserRespository{
// Using collections (userdetails) to store temporarily instead of database
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	//private Map<Integer, UserVO> userdetails =new HashMap<Integer, UserVO>();
	@Override
	public int addUser(UserVO uservo) {
	
		//userdetails.put(uservo.getId(), uservo);
		return jdbcTemplate.update("insert into user(id,FirstName,LastName) values (?,?,?)", uservo.getId(),uservo.getFirstName(),uservo.getLastName());
		//return 1;
	}

	@Override
	public int removeUser(int userId) {

//		UserVO user = userdetails.remove(userId);
//		if(ObjectUtils.isEmpty(user))
//		return 0;
		
		return jdbcTemplate.update("delete from user where id = ?", userId);
	}

	@Override
	public int updateUser(UserVO uservo) {
		// TODO Auto-generated method stub
//		UserVO user = userdetails.get(uservo.getId());
//		if(ObjectUtils.isEmpty(user))
//			return 0;
//		userdetails.put(uservo.getId(), uservo);
		return jdbcTemplate.update("update user set FirstName=?, LastName=? where id=?", uservo.getFirstName(),uservo.getLastName(),uservo.getId());
	}

	@Override
	public UserVO getUser(int userId) {
		
	 return jdbcTemplate.queryForObject("select id,FirstName,LastName from user where id = ?",new UserRowMapper(),userId);
	// System.out.println(s);	
	// return userdetails.get(userId);
	}

	@Override
	public Set<UserVO> getAllUsers() {
	
		return new HashSet<UserVO>(jdbcTemplate.query("select id,FirstName,LastName from user",new UserRowMapper()));
	}
	
	
	class  UserRowMapper implements RowMapper<UserVO>{

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			 UserVO userVO=new UserVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			return userVO;
		}
		
	}
	
	

}
