package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.User;

public interface IUserService {
	
	
	List<User> findAll() throws Exception;

	User findById(long id) throws Exception;

	void save(User user) throws Exception;

	void update(User user) throws Exception;

	void delete(long id) throws Exception;

}
