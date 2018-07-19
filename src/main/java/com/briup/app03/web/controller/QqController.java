package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Qq;
import com.briup.app03.service.IQqService;
import com.briup.app03.util.MsgResponse;
import com.briup.app03.vm.QqVM;

import io.swagger.annotations.Api;
@Api(description = "问题和调查相关接口")
@RestController
@RequestMapping("/qq")
public class QqController {
	@Autowired
	private IQqService qqService;






	@GetMapping("findAll")
	public MsgResponse findAll() {
		try {
			// 调用service代码来进行
			List<Qq> list = qqService.findAll();
			return MsgResponse.success("存在桥表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAllQqVM")
	public MsgResponse findAllQqVM() throws Exception {
		try {
			// 调用service代码来进行
			List<QqVM> list = qqService.findAllQqVM();
			return MsgResponse.success("存在桥表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}






	@PostMapping("updateQq")
	public MsgResponse updateQq(Qq Qq) {
		try {
			qqService.update(Qq);
			return MsgResponse.success("桥表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}

	}


	// http://127.0.0.1:8080/chool/findAllQq

	@PostMapping("delete")
	public MsgResponse delete(long id) {
		try {
			qqService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除桥表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findQqById")
	public MsgResponse findQqById(long id) {
		try {
			Qq qq = qqService.findById(id);

			return MsgResponse.success("查询成功！！",qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}







	@PostMapping("saveqq")
	public MsgResponse saveQq(Qq qq) {
		try {

			qqService.save(qq);
			return MsgResponse.success("桥表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

}	



