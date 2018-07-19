package com.briup.app03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app03.bean.Course;
import com.briup.app03.dao.CourseMapper;
import com.briup.app03.service.ICourseService;

@Service

public class CourseServiceImpl implements ICourseService {
	

	@Autowired
	private CourseMapper courseMapper;
	
	

	
	@Override
	public List<Course> findAll() throws Exception{
		//先通过courseMapper对象查询学生链表
		List<Course> list =courseMapper.findAll();
		
		if(list !=null){
		return list;
		}else{
			throw new Exception();
		}
		
	}
	
	
	public Course findById(long id) throws Exception{
		Course course=courseMapper.findById(id);
		if(course!=null){
			courseMapper.findById(id);
		}else{
			throw new Exception("课表查询失败！！！");
		}
		
		
		return courseMapper.findById(id);
	}
	//通过id查找数据
	@Override
	public  void save( Course  course) throws Exception{
		
		if(  course.getName()!=null){
			courseMapper.save(course);
		}else{
			throw new Exception("课表保存失败！！！");
		}
		courseMapper.save(course);
	}
	
	//
    @Override
    //通过id更新学生表 
     public void update(Course course) throws Exception{
    	Course newCourse=courseMapper.findById(course.getId());
    	if(newCourse!=null){
    		courseMapper.update(course);
    	}else{
    		throw new Exception("课表更新不存在");
    	}
    		
    }
	@Override
	public void delete(long id) throws Exception {
		Course course= courseMapper.findById(id);
		if(course!=null){
			courseMapper.delete(id);
		}else
		{
			throw new Exception("对不起 ，课表不存在！！！！");
		}
		// TODO Auto-generated method stub
		
	}

}
