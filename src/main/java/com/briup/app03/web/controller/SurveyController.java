package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.Survey;
import com.briup.app03.service.ISurveyService;
import com.briup.app03.util.MsgResponse;

@RestController
@RequestMapping("/survey")
public class SurveyController {

	//注入SurveyService的实例
			@Autowired
			private ISurveyService SurveyService;

			@PostMapping("saveSurvey")
			public MsgResponse saveSurvey(Survey survey) {
				try {

					SurveyService.save(survey);
					return MsgResponse.success("课调表保存成功！！！", null);

				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}

			}

			@PostMapping("updateSurvey")
			public MsgResponse updateSurvey(Survey survey) {
				try {
					SurveyService.update(survey);
					return MsgResponse.success("课调表更新成功！", null);
				} catch (Exception e) {
					return MsgResponse.error(e.getMessage());

				}
			}

			// http://127.0.0.1:8080/survey/findAllSurvey
			@GetMapping("findAllSurvey")
			public MsgResponse findAllSurvey() {
				try {
					// 调用service代码来进行
					List<Survey> list = SurveyService.findAll();
					return MsgResponse.success("存在课调表", list);
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
					SurveyService.delete(id);
					return MsgResponse.success("删除成功！", null);
					// 返回值为空 ，因为通过id删除课表对象不需要返回值

				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}

			@GetMapping("findSurveyById")
			public MsgResponse findSurveyById(long id) {
				try {
					Survey survey = SurveyService.findById(id);

					return MsgResponse.success("查询成功！！",survey);
				} catch (Exception e) {
					e.printStackTrace();
					return MsgResponse.error(e.getMessage());
				}
			}
		}


