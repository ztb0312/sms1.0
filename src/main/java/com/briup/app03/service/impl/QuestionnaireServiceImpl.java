package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Questionnaire;

import com.briup.app03.dao.QuestionnaireMapper;
import com.briup.app03.dao.extend.QuestionnaireVMMapper;
import com.briup.app03.service.IQuestionnaireService;
import com.briup.app03.vm.QuestionnaireVM;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
@Override

	public List<Questionnaire> findAll() throws Exception {
		// 先通过gradeMapper对象查询问卷链表
		List<Questionnaire> list = questionnaireMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception("不存在！");
		}

	}

@Override
public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
	List <QuestionnaireVM> questionnaireVM = questionnaireVMMapper.findAllQuestionnaireVM();
	if(questionnaireVM != null){
		return questionnaireVM;
	}
	else{
		throw new Exception("不存在！");
	}
}





	public Questionnaire findById(long id) throws Exception {
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if (questionnaire != null) {
			questionnaireMapper.findById(id);
		} else {
			throw new Exception("问卷查询失败！！！");
		}

		return questionnaireMapper.findById(id);
	}

	// 通过id查找调查问卷数据
	@Override
	public void save(Questionnaire questionnaire) throws Exception {

		if (questionnaire.getName() != null) {
			questionnaireMapper.save(questionnaire);
		} else {
			throw new Exception("问卷保存失败！！！");
		}
		questionnaireMapper.save(questionnaire);
	}

	//
	@Override
	// 通过id更新问卷表
	public void update(Questionnaire questionnaire) throws Exception {
		Questionnaire newQuestionnaire = questionnaireMapper.findById(questionnaire.getId());
		if (newQuestionnaire != null) {
			questionnaireMapper.update(questionnaire);
		} else {
			throw new Exception("问卷表更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if (questionnaire != null) {
			questionnaireMapper.delete(id);
		} else {
			throw new Exception("对不起 ，问卷表存在！！！！");
		}

	}
}
