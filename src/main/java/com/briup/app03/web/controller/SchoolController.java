package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.School;
import com.briup.app03.service.ISchoolService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description = "校园相关接口")
	@RestController
	@RequestMapping("/school")
	public class SchoolController {
		//注入schoolService的实例
		@Autowired
		private ISchoolService schoolService;

		@PostMapping("saveSchool")
		public MsgResponse saveSchool(School school) {
			try {

				schoolService.save(school);
				return MsgResponse.success("学校表保存成功！！！", null);

			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}

		}

		@PostMapping("updateSchool")
		public MsgResponse updateSchool(School school) {
			try {
				schoolService.update(school);
				return MsgResponse.success("学校表更新成功！", null);
			} catch (Exception e) {
				return MsgResponse.error(e.getMessage());

			}
		}

		// http://127.0.0.1:8080/chool/findAllschool
		@GetMapping("findAllSchool")
		public MsgResponse findAllSchool() {
			try {
				// 调用service代码来进行
				List<School> list = schoolService.findAll();
				return MsgResponse.success("存在学校表", list);
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
				schoolService.delete(id);
				return MsgResponse.success("删除成功！", null);
				// 返回值为空 ，因为通过id删除课表对象不需要返回值

			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

		@GetMapping("findSchoolById")
		public MsgResponse findSchoolById(long id) {
			try {
				School school = schoolService.findById(id);

				return MsgResponse.success("查询成功！！",school);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	}
		


