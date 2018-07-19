package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Question;
//import com.briup.app03.bean.Question;
import com.briup.app03.service.IQuestionService;
import com.briup.app03.util.MsgResponse;
import com.briup.app03.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;// 接口的实例化

	@ApiOperation(value = "查询所有问题", notes = "级联查询出属于该题目的选项")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM() {
		try {
			// 调用service代码来进行
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("存在问题表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查询所有问题",notes="只查询所有问题，不包括其答案")
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {

		try{
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

}
	
	
	
	@ApiOperation(value = "保存问题", notes = "保存问题的同时还应该保存选项,question_id,option id ,question id都不用输入")
	@PostMapping("saveQuestion")

	public MsgResponse saveQuestion(QuestionVM questionVM) {/// 接收参数
		try {
           //调用业务逻辑层的保存方法
			
			questionService.saveQuestion(questionVM);
			return MsgResponse.success("问题表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	
	
	@PostMapping("updateQuestion")
	public MsgResponse updateQuestion(Question question) {
		try {
			questionService.update(question);
			return MsgResponse.success("问题更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/question/findAllquestion

	@PostMapping("delete")
	public MsgResponse delete(long id) {
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除问题对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findQuestionById")
	public MsgResponse findSchoolById(long id) {
		try {
			Question question = questionService.findById(id);

			return MsgResponse.success("查询成功！！", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
