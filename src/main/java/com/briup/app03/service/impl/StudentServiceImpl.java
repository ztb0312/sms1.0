package com.briup.app03.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.app03.bean.Student;
import com.briup.app03.dao.StudentMapper;
import com.briup.app03.service.IStudentService;
@Service

public class StudentServiceImpl implements IStudentService {
	
	
	
	@Autowired
	private StudentMapper studentMapper;
	
	

	
	@Override
	public List<Student> findAll() throws Exception{
		
		List<Student> list =studentMapper.findAll();
		return list;
	}
	public Student findById(long id) throws Exception{
		Student student=studentMapper.findById(id);
		if(student!=null){
			studentMapper.findById(id);
		}else{
			throw new Exception("查询失败！！！");
		}
		
		
		return studentMapper.findById(id);
	}
	//通过id查找数据
	@Override
	public  void save(Student student) throws Exception{
		
		if( student.getName()!=null){
			studentMapper.save(student);
		}else{
			throw new Exception("保存失败！！！");
		}
		studentMapper.save(student);
	}
	
	//
    @Override
     public void update(Student student) throws Exception{
    	Student newStudent=studentMapper.findById(student.getId());
    	if(newStudent!=null){
    		studentMapper.update(student);
    	}else{
    		throw new Exception("更新不存在");
    	}
    		
    }
	@Override
	public void delete(long id) throws Exception {
		Student student = studentMapper.findById(id);
		if(student!=null){
			studentMapper.delete(id);
		}else
		{
			throw new Exception("对不起 ，学生不存在！！！！");
		}
		// TODO Auto-generated method stub
		
	}
}
