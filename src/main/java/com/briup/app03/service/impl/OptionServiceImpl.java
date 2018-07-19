package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Option;
import com.briup.app03.dao.OptionMapper;
import com.briup.app03.service.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService {

	@Autowired
	private OptionMapper optionMapper;

	@Override
	public List<Option> findAll() throws Exception {
		// 先通过 optionMapper对象查询选项
		List<Option> list = optionMapper.findAll();

		if (list != null) {
			return list;
		} else {
			throw new Exception();
		}

	}

	public Option findById(long id) throws Exception {
		Option option = optionMapper.findById(id);
		if (option != null) {
			optionMapper.findById(id);
		} else {
			throw new Exception("选项查询失败！！！");
		}

		return optionMapper.findById(id);
	}

	// 通过id查找数据
	@Override
	public void save(Option option) throws Exception {

		if (option.getContent() != null) {
			optionMapper.save(option);
		} else {
			throw new Exception("选项保存失败！！！");
		}
		optionMapper.save(option);
	}

	//
	@Override
	// 通过id更新选项表
	public void update(Option option) throws Exception {
		Option newOption =optionMapper.findById(option.getId());
		if (newOption != null) {
			optionMapper.update(option);
		} else {
			throw new Exception("选项更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Option option = optionMapper.findById(id);
		if (option != null) {
			optionMapper.delete(id);
		} else {
			throw new Exception("对不起 ，选项不存在！！！！");
		}

	}

}
	

