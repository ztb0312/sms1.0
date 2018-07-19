package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Clazz;
import com.briup.app03.vm.ClazzVM;

public interface IClazzService {
	
	
	List<ClazzVM> findAllClazzVM() throws Exception;// service层告诉容易抛异常

	List<Clazz> findAll() throws Exception;
	Clazz findById(long id) throws Exception;
    ClazzVM findVMById(long id ) throws Exception;
	void save(Clazz clazz) throws Exception;

	void update(Clazz clazz) throws Exception;

	void delete(long id) throws Exception;
}
