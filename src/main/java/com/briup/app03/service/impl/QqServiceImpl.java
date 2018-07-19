package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Qq;
import com.briup.app03.dao.QqMapper;
import com.briup.app03.service.IQqService;
import com.briup.app03.vm.QqVM;
import com.briup.app03.dao.extend.QqVMMapper;
@Service



public class QqServiceImpl implements IQqService {
	
	
	

	@Autowired
	private QqMapper qqMapper;
	@Autowired
	private QqVMMapper qqVMMapper;
	@Override
	
	public List<Qq> findAll() throws Exception {
		List<Qq> list=qqMapper.findAll();
		return list;
	}
	
	@Override
	public List<QqVM> findAllQqVM() throws Exception{
		
		List<QqVM> list=qqVMMapper.findAllQqVM();
		return list;
		
	}
		  


	public Qq findById(long id) throws Exception {
		Qq qq =qqMapper.findById(id);
		if (qq != null) {
			qqMapper.findById(id);
		} else {
			throw new Exception("桥表查询失败！！！");
		}

		return qqMapper.findById(id);
	}

	// 通过id查找桥表数据
	@Override
	public void save(Qq qq) throws Exception {

		if (qq.getId() != null) {
			qqMapper.save(qq);
		} else {
			throw new Exception("桥表保存失败！！！");
		}
		qqMapper.save(qq);
	}

	//
	@Override
	// 通过id更新学校表
	public void update(Qq qq) throws Exception {
	    Qq newQq =  qqMapper.findById( qq.getId());
		if (newQq != null) {
			qqMapper.update(qq);
		} else {
			throw new Exception("桥表更新不存在");
		}

	}

	@Override
	public void delete(long id) throws Exception {
		Qq qq = qqMapper.findById(id);
		if (qq != null) {
			qqMapper.delete(id);
		} else {
			throw new Exception("对不起 ，桥表不存在！！！！");
		}
		

	}



	
}

	
	


