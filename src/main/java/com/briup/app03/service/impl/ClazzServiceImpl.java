package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Clazz;
import com.briup.app03.dao.ClazzMapper;
import com.briup.app03.dao.extend.ClazzVMMapper;
import com.briup.app03.service.IClazzService;
import com.briup.app03.vm.ClazzVM;


@Service  //标识类的身份
public class ClazzServiceImpl implements IClazzService {    
	//ClazzServiceImpl类用于实现接口IClazzService
	
	
	
	

	@Autowired //注入ClazzMapper,让spring产生一个clazzMapper对象，然后传送过来
	private ClazzMapper clazzMapper;//提供一个ClazzMapper类型的对象（变量）
	@Autowired
	private ClazzVMMapper clazzVMMapper; 
	

	
	@Override
	public List<Clazz> findAll() throws Exception{
		//先通过clazzMapper对象查询班级链表
		List<Clazz> list=clazzMapper.findAll();
		return list;
	}
	
	
	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception{
		
		List<ClazzVM> list=clazzVMMapper.findAllClazzVM();
		return list;
		  
	}
	
	
	
	
	
	
	//通过id查找班级数据
     @Override
	public Clazz findById(long id) throws Exception{
		Clazz clazz=clazzMapper.findById(id);
		if(clazz!=null){
			clazzMapper.findById(id);
		}else{
			throw new Exception("班级表查询失败！！！");
		}
		
		
		return clazzMapper.findById(id);
	}
	

     @Override
 	public ClazzVM findVMById(long id) throws Exception {
    	 
    		ClazzVM clazzVM=clazzVMMapper.findVMById(id);
    		if(clazzVM!=null){
    			clazzVMMapper.findVMById(id);
    		}else{
    			throw new Exception("班级表查询失败！！！");
    		}
    		
    		
    		return clazzVMMapper.findVMById(id);
    	 
    
 		
 	}
     
	
	//保存班级数据
	@Override
	public  void save( Clazz  clazz) throws Exception{
		
		if(   clazz.getName()!=null){
			 clazzMapper.save( clazz);
		}else{
			throw new Exception("班级表保存失败！！！");
		}
		 clazzMapper.save(clazz);
	}
	

    @Override
    //通过id更新班级表 
     public void update( Clazz  clazz) throws Exception{
    	 Clazz newClazz= clazzMapper.findById( clazz.getId());
    	if(newClazz!=null){
    		 clazzMapper.update( clazz);
    	}else{
    		throw new Exception("班级表更新不存在");
    	}
    }
    
    
	@Override
	//删除班级表
	public void delete(long id) throws Exception {
		Clazz  clazz=  clazzMapper.findById(id);
		if( clazz!=null){
			 clazzMapper.delete(id);
		}else
		{
			throw new Exception("对不起 ，班级表不存在！！！！");
		}
	}



}

