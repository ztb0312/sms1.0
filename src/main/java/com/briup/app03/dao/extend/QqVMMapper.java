package com.briup.app03.dao.extend;

import java.util.List;

import com.briup.app03.vm.QqVM;

public interface QqVMMapper {  
	 


	List<QqVM> findAllQqVM();
	
    List<QqVM> findAllQuestion();
    
    List<QqVM> findAllQuestionnaier();
}
