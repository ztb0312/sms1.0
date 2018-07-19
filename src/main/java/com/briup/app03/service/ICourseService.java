package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Course;

public interface ICourseService {
	List<Course> findAll() throws Exception;// service层告诉容易抛异常

	Course findById(long id) throws Exception;

	void save(Course course) throws Exception;

	void update(Course course) throws Exception;

	void delete(long id) throws Exception;


}
