package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Grade;
import com.briup.app03.dao.GradeMapper;
import com.briup.app03.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {
	
	
	
	@Autowired
	private GradeMapper gradeMapper;

	public List<Grade> findAll() throws Exception {
		// 先通过gradeMapper对象查询年级链表
		List<Grade> list = gradeMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public Grade findById(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if (grade != null) {
			gradeMapper.findById(id);
		} else {
			throw new Exception("年级查询失败！！！");
		}

		return gradeMapper.findById(id);
	}

	// 通过id查找年级数据
	@Override
	public void save(Grade grade) throws Exception {

		if (grade.getName() != null) {
			gradeMapper.save(grade);
		} else {
			throw new Exception("年级保存失败！！！");
		}
		gradeMapper.save(grade);
	}

	//
	@Override
	// 通过id更新年级表
	public void update(Grade grade) throws Exception {
		Grade newGrade = gradeMapper.findById(grade.getId());
		if (newGrade != null) {
			gradeMapper.update(grade);
		} else {
			throw new Exception("年级更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if (grade != null) {
			gradeMapper.delete(id);
		} else {
			throw new Exception("对不起 ，年级表存在！！！！");
		}

	}
	}

