package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Answer;

public interface IAnswerService {
	List<Answer> findAll() throws Exception;// service层告诉容易抛异常

	Answer findById(long id) throws Exception;

	void save(Answer answer) throws Exception;

	void update(Answer answer) throws Exception;

	void delete(long id) throws Exception;
}


