package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Questionnaire;
import com.briup.app03.vm.QuestionnaireVM;

public interface IQuestionnaireService {
	
	
	List<Questionnaire> findAll() throws Exception;// service层告诉容易抛异常

	List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception;
	Questionnaire findById(long id) throws Exception;

	void save(Questionnaire questionnaire) throws Exception;

	void update(Questionnaire questionnaire) throws Exception;

	void delete(long id) throws Exception;

}
