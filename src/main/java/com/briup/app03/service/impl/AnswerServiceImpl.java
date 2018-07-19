package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Answer;
import com.briup.app03.dao.AnswerMapper;
import com.briup.app03.service.IAnswerService;

@Service
public class AnswerServiceImpl implements IAnswerService {

	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> findAll() throws Exception {
		// 先通过 answerMapper对象查询答案
		List<Answer> list = answerMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public Answer findById(long id) throws Exception {
		Answer answer = answerMapper.findById(id);
		if (answer != null) {
			answerMapper.findById(id);
		} else {
			throw new Exception("答案查询失败！！！");
		}

		return answerMapper.findById(id);
	}

	// 通过id查找数据
	@Override
	public void save(Answer answer) throws Exception {

		if (answer.getContent() != null) {
			answerMapper.save(answer);
		} else {
			throw new Exception("答案保存失败！！！");
		}
		answerMapper.save(answer);
	}

	//
	@Override
	// 通过id更新学生表
	public void update(Answer answer) throws Exception {
		Answer newAnswer = answerMapper.findById(answer.getId());
		if (newAnswer != null) {
			answerMapper.update(answer);
		} else {
			throw new Exception("答案更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Answer answer = answerMapper.findById(id);
		if (answer != null) {
			answerMapper.delete(id);
		} else {
			throw new Exception("对不起 ，答案不存在！！！！");
		}

	}

}
