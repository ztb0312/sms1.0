package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Answer;
import com.briup.app03.service.IAnswerService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;
@Api(description = "答案相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {

	
	
	@Autowired
	private IAnswerService answerService;

	@PostMapping("saveAnswer")
	public MsgResponse saveAnswer(Answer answer) {
		try {

			answerService.save(answer);
			return MsgResponse.success("答案保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateAnswer")
	public MsgResponse updateAnswer(Answer answer) {
		try {
			answerService.update(answer);
			return MsgResponse.success("答案更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/answer/findAllanswer
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer() {
		try {
			// 调用service代码来进行
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("存在答案", list);
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
			answerService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除答案对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findAnswerById")
	public MsgResponse findAnswerById(long id) {
		try {
			Answer answer =answerService.findById(id);

			return MsgResponse.success("查询成功！！",answer);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
