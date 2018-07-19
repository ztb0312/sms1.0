package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Grade;

public interface IGradeService {
	List<Grade> findAll() throws Exception;// service层告诉容易抛异常

	Grade findById(long id) throws Exception;

	void save(Grade grade) throws Exception;

	void update(Grade grade) throws Exception;

	void delete(long id) throws Exception;
}
