package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean. User;
import com.briup.app03.dao. UserMapper;
import com.briup.app03.service.IUserService;

@Service

public class UserServiceImpl implements IUserService {
	
	@Autowired
	private  UserMapper  userMapper;

	public List< User> findAll() throws Exception {
		// 先通过 userMapper对象查询学校链表
		List< User> list =  userMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public User findById(long id) throws Exception {
		 User  user =  userMapper.findById(id);
		if ( user != null) {
			 userMapper.findById(id);
		} else {
			throw new Exception("用户查询失败！！！");
		}

		return  userMapper.findById(id);
	}

	// 通过id查找用户数据
	@Override
	public void save( User  user) throws Exception {

		if ( user.getName() != null) {
			 userMapper.save(user);
		} else {
			throw new Exception("用户保存失败！！！");
		}
		 userMapper.save( user);
	}

	//
	@Override
	// 通过id更新学校表
	public void update( User  user) throws Exception {
		 User newUser =  userMapper.findById( user.getId());
		if (newUser != null) {
			 userMapper.update( user);
		} else {
			throw new Exception("用户更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		 User  user =  userMapper.findById(id);
		if ( user != null) {
			 userMapper.delete(id);
		} else {
			throw new Exception("对不起 ，用户不存在！！！！");
		}
		

	
	
	}
}
