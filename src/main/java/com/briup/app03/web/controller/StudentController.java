package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Student;
import com.briup.app03.service.IStudentService;
import com.briup.app03.util.MsgResponse;



@RestController
@RequestMapping("/student")
public class StudentController {
	// 注入studentService的实例
	@Autowired
	private IStudentService studentService;

	@PostMapping("saveStudent")
	public MsgResponse saveStudent(Student student) {
		try {

			studentService.save(student);
			return MsgResponse.success("保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateStudent")
	public MsgResponse updateStudent(Student student) {
		try {
			studentService.update(student);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent() {
		try {
			// 调用service代码来进行
			List<Student> list = studentService.findAll();
			return MsgResponse.success("存在学生表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("delete")
	public MsgResponse delete(long id) {
		try {
			studentService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除学生对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id) {
		try {
			Student student = studentService.findById(id);

			return MsgResponse.success("查询成功！！", student);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
