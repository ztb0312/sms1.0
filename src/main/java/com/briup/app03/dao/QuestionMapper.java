package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Question;

public interface QuestionMapper {
	List<Question> findAll();
	Question findById(long id);
   
	
	
	void save(Question question);
	
	void update(Question question);
	void delete(long id);
	void deleteById(long id);


}
