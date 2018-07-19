package com.briup.app03.dao.extend;

import java.util.List;

import com.briup.app03.vm.QuestionnaireVM;

public interface QuestionnaireVMMapper {
	List<QuestionnaireVM> findAllQuestionnaireVM();
	QuestionnaireVM findByIdQuestionnaireVM(long id);
}
