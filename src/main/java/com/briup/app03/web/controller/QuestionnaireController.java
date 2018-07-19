package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Questionnaire;
import com.briup.app03.service.IQuestionnaireService;
import com.briup.app03.util.MsgResponse;
import com.briup.app03.vm.QuestionnaireVM;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	// 注入schoolService的实例
	@Autowired
	private IQuestionnaireService questionnaireService;

	@GetMapping("/findAll")
	// http://127.0.0.1:8080/questionnaire/findAllquestionnaire
	public MsgResponse findAll() throws Exception {

		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功！", list);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	@GetMapping("findAllQuestionnaireVM")
	public MsgResponse findAllQuestionnaireVM() throws Exception {

		try {
			List<QuestionnaireVM> list = questionnaireService.findAllQuestionnaireVM();
			return MsgResponse.success("查询成功！", list);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	// 保存
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveQuestionnaire(Questionnaire questionnaire) {
		try {

			questionnaireService.save(questionnaire);
			return MsgResponse.success("问卷表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	// 更新
	@PostMapping("updateQuestionnaire")
	public MsgResponse updateQuestionnaire(Questionnaire questionnaire) {
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("问卷表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// 删除
	@PostMapping("delete")
	public MsgResponse delete(long id) {
		try {
			questionnaireService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除课表对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 查询
	@GetMapping("findQuestionnaireById")
	public MsgResponse findSchoolById(long id) {
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);

			return MsgResponse.success("查询成功！！", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
