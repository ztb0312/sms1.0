package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.School;

public interface ISchoolService {
	
	List<School> findAll() throws Exception;

	School findById(long id) throws Exception;

	void save(School school) throws Exception;

	void update(School school) throws Exception;

	void delete(long id) throws Exception;


}
