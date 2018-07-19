package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Grade;

public interface GradeMapper {
	List<Grade> findAll();
	Grade findById(long id);
   
	
	
	void save(Grade grade);
	
	void update(Grade grade);
	void delete(long id);

}
