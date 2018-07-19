package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Grade;
import com.briup.app03.service.IGradeService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;
@Api(description = "年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	// 注入gradeService的实例
	@Autowired
	private IGradeService gradeService;

	@PostMapping("saveGrade")
	public MsgResponse saveGrade(Grade grade) {
		try {

			gradeService.save(grade);
			return MsgResponse.success("年级表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateGrade")
	public MsgResponse updateCourse(Grade grade) {
		try {
			gradeService.update(grade);
			return MsgResponse.success("年级表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/grade/findAllGrade
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade() {
		try {
			// 调用service代码来进行
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("存在年级表", list);
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
			gradeService.delete(id);
			return MsgResponse.success("年级删除成功！", null);
			// 返回值为空 ，因为通过id删除年级表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findGradeById")
	public MsgResponse findGradeById(long id) {
		try {
			Grade grade = gradeService.findById(id);

			return MsgResponse.success("年级查询成功！！", grade);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
