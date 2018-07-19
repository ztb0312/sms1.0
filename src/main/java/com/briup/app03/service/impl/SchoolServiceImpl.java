package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.School;
import com.briup.app03.dao.SchoolMapper;
import com.briup.app03.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {

	@Autowired
	private SchoolMapper schoolMapper;

	public List<School> findAll() throws Exception {
		// 先通过schoolMapper对象查询学校链表
		List<School> list = schoolMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public School findById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if (school != null) {
			schoolMapper.findById(id);
		} else {
			throw new Exception("学校查询失败！！！");
		}

		return schoolMapper.findById(id);
	}

	// 通过id查找学校数据
	@Override
	public void save(School school) throws Exception {

		if (school.getName() != null) {
			schoolMapper.save(school);
		} else {
			throw new Exception("学校保存失败！！！");
		}
		schoolMapper.save(school);
	}

	//
	@Override
	// 通过id更新学校表
	public void update(School school) throws Exception {
		School newSchool = schoolMapper.findById(school.getId());
		if (newSchool != null) {
			schoolMapper.update(school);
		} else {
			throw new Exception("学校更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if (school != null) {
			schoolMapper.delete(id);
		} else {
			throw new Exception("对不起 ，学校不存在！！！！");
		}
		// TODO Auto-generated method stub

	}
}
