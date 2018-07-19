package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Option;
import com.briup.app03.service.IOptionService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;
@Api(description = "选项相关接口")
@RestController
@RequestMapping("/option")
public class OptionController {

	// 注入schoolService的实例
	@Autowired
	private IOptionService optionService;

	@PostMapping("saveOption")
	public MsgResponse saveClazz(Option option) {
		try {

			optionService.save(option);
			return MsgResponse.success("选项表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateOption")
	public MsgResponse updateOption(Option option) {
		try {
			optionService.update(option);
			return MsgResponse.success("选项表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	@GetMapping("findAllOption")
	public MsgResponse findAllOption() {
		try {
			// 调用service代码来进行
			List<Option> list = optionService.findAll();
			return MsgResponse.success("存在选项表", list);
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
			optionService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除选项表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findOptionById")
	public MsgResponse findOptionById(long id) {
		try {
			Option option = optionService.findById(id);

			return MsgResponse.success("查询成功！！", option);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
