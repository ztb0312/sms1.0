package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Survey;
import com.briup.app03.dao.SurveyMapper;
import com.briup.app03.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService {
	
	
	
	@Autowired
	private SurveyMapper SurveyMapper;

	public List<Survey> findAll() throws Exception {
		// 先通过SurveyMapper对象查询课调链表
		List<Survey> list = SurveyMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public Survey findById(long id) throws Exception {
		Survey Survey = SurveyMapper.findById(id);
		if (Survey != null) {
			SurveyMapper.findById(id);
		} else {
			throw new Exception("课调查询失败！！！");
		}

		return SurveyMapper.findById(id);
	}

	// 通过id查找课调数据
	@Override
	public void save(Survey survey) throws Exception {

		if (survey.getState() != null) {
			SurveyMapper.save(survey);
		} else {
			throw new Exception("课调保存失败！！！");
		}
		SurveyMapper.save(survey);
	}

	//
	@Override
	// 通过id更新学校表
	public void update(Survey survey) throws Exception {
		Survey newSurvey = SurveyMapper.findById(survey.getId());
		if (newSurvey != null) {
			SurveyMapper.update(survey);
		} else {
			throw new Exception("课调更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Survey survey = SurveyMapper.findById(id);
		if (survey != null) {
			SurveyMapper.delete(id);
		} else {
			throw new Exception("对不起 ，课调不存在！！！！");
		}
		// TODO Auto-generated method stub

	}

}
