package com.briup.app03.dao.extend;

import java.util.List;

import com.briup.app03.vm.QuestionVM;

public interface QuestionVMMapper {
	List<QuestionVM> findAllQuestionVM();

	QuestionVM findByIdQuestionVM(long id);
	

}
