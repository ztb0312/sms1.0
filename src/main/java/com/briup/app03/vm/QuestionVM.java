package com.briup.app03.vm;

import java.util.List;

import com.briup.app03.bean.Option;

public class QuestionVM {
	private Long id;
	private String name;
	private String questiontype;
	private List<Option> options;
	private QqVM qqVM;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public QqVM getQqVM() {
		return qqVM;
	}
	public void setQqVM(QqVM qqVM) {
		this.qqVM = qqVM;
	}
	
	
}
