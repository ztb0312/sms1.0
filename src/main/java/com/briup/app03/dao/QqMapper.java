package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Qq;

public interface QqMapper {
	List<Qq> findAll();
	List<Qq> findByQuestionId(long id);
	
	Qq findById(long id);
	void save(Qq qq);
	
	void update(Qq qq);
	void delete(long id);


}
