package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Qq;
import com.briup.app03.vm.QqVM;

public interface IQqService {

	
	
	List<QqVM> findAllQqVM() throws Exception;
	List<Qq> findAll() throws Exception;
	
	
	Qq findById(long id) throws Exception;

	void save(Qq qq) throws Exception;

	void update(Qq qq) throws Exception;

	void delete(long id) throws Exception;

}
