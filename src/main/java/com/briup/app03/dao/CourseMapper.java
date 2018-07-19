package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Course;

public interface CourseMapper {
	List<Course> findAll();
	Course findById(long id);
   
	
	
	void save(Course course);
	
	void update(Course course);
	void delete(long id);


}
