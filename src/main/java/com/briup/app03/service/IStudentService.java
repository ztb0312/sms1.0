package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Student;

public interface IStudentService {
	
	List<Student> findAll() throws Exception;

	Student findById(long id) throws Exception;

	void save(Student student) throws Exception;

	void update(Student student) throws Exception;

	void delete(long id) throws Exception;

}
