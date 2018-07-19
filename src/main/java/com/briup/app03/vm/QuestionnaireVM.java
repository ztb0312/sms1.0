package com.briup.app03.vm;

import java.util.List;

public class QuestionnaireVM {
	private Long id;
	private String name;
	private String description;
	private String createdate;
	private List<QqVM> qqVM;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public List<QqVM> getQqVM() {
		return qqVM;
	}

	public void setQqVM(List<QqVM> qqVM) {
		this.qqVM = qqVM;
	}
}