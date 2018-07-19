package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Option;

public interface IOptionService {
	List<Option> findAll() throws Exception;

	Option findById(long id) throws Exception;

	void save(Option option) throws Exception;

	void update(Option option) throws Exception;

	void delete(long id) throws Exception;
}
