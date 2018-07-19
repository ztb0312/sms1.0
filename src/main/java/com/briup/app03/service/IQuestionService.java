package com.briup.app03.service;

import java.util.List;

import com.briup.app03.bean.Question;
import com.briup.app03.vm.QuestionVM;

public interface IQuestionService {

	List<QuestionVM> findAllQuestionVM() throws Exception;
    List<Question> findAll() throws Exception;
	Question findById(long id) throws Exception;
	QuestionVM findByIdQuestionVM(long id) throws Exception;
	
	
    void saveQuestion(QuestionVM questionVM) throws Exception;
	void update(Question question) throws Exception;

	void deleteById(long id) throws Exception;
	void save(Question question) throws Exception;


}
