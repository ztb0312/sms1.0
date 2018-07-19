package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Clazz;
import com.briup.app03.service.IClazzService;
import com.briup.app03.util.MsgResponse;
import com.briup.app03.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {

	// 注入schoolService的实例
	@Autowired
	private IClazzService clazzService;

	@PostMapping("saveClazz")
	public MsgResponse saveClazz(Clazz clazz) {
		try {

			clazzService.save(clazz);
			return MsgResponse.success("班级表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return MsgResponse.success("班级表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}
	
	
	

	// http://127.0.0.1:8080/clazz/findAllclazz
	@ApiOperation(value = "查询所有班级", notes = "查询班级的基本信息，并且查看年级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz() {
		try {
			// 调用service代码来进行
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("存在班级表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM() {
		try {
			// 调用service代码来进行
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("存在班级表", list);
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
			clazzService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除班级表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findClazzById")
	public MsgResponse findClazzById(long id) {
		try {
			Clazz clazz = clazzService.findById(id);

			return MsgResponse.success("查询成功！！", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	@GetMapping("findClazzVMById")
	public MsgResponse findClazzVMById(long id) {
		try {
			ClazzVM clazzVM = clazzService.findVMById(id);

			return MsgResponse.success("查询成功！！", clazzVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}



