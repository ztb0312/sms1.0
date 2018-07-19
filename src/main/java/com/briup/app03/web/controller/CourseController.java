package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Course;
import com.briup.app03.service.ICourseService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;
@Api(description = "课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	//注入courseService的实例
	@Autowired
	private ICourseService courseService;

	@PostMapping("saveCourse")
	public MsgResponse saveCourse(Course course) {
		try {

			courseService.save(course);
			return MsgResponse.success("课表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course) {
		try {
			courseService.update(course);
			return MsgResponse.success("课表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/course/findAllCourse
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {
		try {
			// 调用service代码来进行
			List<Course> list = courseService.findAll();
			return MsgResponse.success("存在课程表", list);
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
			courseService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除课表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id) {
		try {
			Course course = courseService.findById(id);

			return MsgResponse.success("查询成功！！",course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	

}
