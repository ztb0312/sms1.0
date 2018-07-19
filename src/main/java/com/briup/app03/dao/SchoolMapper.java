package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.School;

public interface SchoolMapper {
	List<School> findAll();
	School findById(long id);
   
	
	
	void save(School school);
	
	void update(School school);
	void delete(long id);
}
