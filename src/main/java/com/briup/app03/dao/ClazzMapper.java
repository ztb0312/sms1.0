package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Clazz;

public interface ClazzMapper {
	List<Clazz> findAll();
	Clazz findById(long id);
   
	
	
	void save(Clazz clazz);
	
	void update(Clazz clazz);
	void delete(long id);


}
