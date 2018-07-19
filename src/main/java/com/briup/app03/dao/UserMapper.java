package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.User;

public interface UserMapper {
	List<User> findAll();
	User findById(long id);
   
	
	
	void save(User user);
	
	void update(User user);
	void delete(long id);


}
