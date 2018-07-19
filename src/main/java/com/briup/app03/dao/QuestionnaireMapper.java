package com.briup.app03.dao;

import java.util.List;

import com.briup.app03.bean.Questionnaire;

public interface QuestionnaireMapper {
	List<Questionnaire> findAll();
	Questionnaire findById(long id);
   
	
	
	void save(Questionnaire questionnaire);
	
	void update(Questionnaire questionnaire);
	void delete(long id);

}
